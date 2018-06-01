package com.company.GMapClient;

import java.net.URL;
import java.util.Scanner;

/**
 * Client used to read JSON Files from API call
 */
public class GMapClient {

    /**
     * Base_URL:    The specific url of the API that is used, Google Map Distance Matrix
     * API_KEY:     Google Maps API Key
     */
    private static final String BASE_URL = "https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial";
    private static final String API_KEY = "AIzaSyBHCIKRWAjpI9-GVM-jgABj3HT1sYtz5lQ";

    /**
     * Function used to call on the Google Maps Distance Matrix API to calculate the distance
     * to travel, as well as the amount of time traveled. This version of the API call does not account
     * for traffic (As that is the premium version of the key)
     * @param str_lat1 Latitude coordinates of origin
     * @param str_lon1 Longitude coordinates of origin
     * @param str_lat2 Latitude coordinates of destination
     * @param str_lon2 Longitude coordinates of destination
     * @return Returns the distance in miles[0], as well as estimated minutes traveled[1]
     * @throws Exception
     */
    public static double[] geomatrixDistance(String str_lat1, String str_lon1, String str_lat2, String str_lon2) throws Exception
    {

        //Creates the URL for API CALL
        URLMaker maker = new URLMaker(BASE_URL, API_KEY);
        String addr = maker.getURL(str_lat1, str_lon1, str_lat2, str_lon2);
        URL url = new URL(addr);
        Double miles;
        Double mins;
        String hours = "0";
        String minutes = "0";

        // Calls on API through URL
        Scanner scan = new Scanner(url.openStream());
        String json_Str = "";
        while (scan.hasNext())
            json_Str += scan.nextLine();
        scan.close();



        // build a JSON object of the entire JSON File
        org.json.JSONObject obj = new org.json.JSONObject(json_Str);

        if (! obj.getString("status").equals("OK")) {
            System.out.println(obj.getString("error_message"));
            return null;
        }

        // Get the rows array from the original JSON Object
        org.json.JSONArray rows = (org.json.JSONArray) obj.get("rows");
        org.json.JSONObject rows_Object = (org.json.JSONObject) rows.get(0);

        //Get the elements array from the rows array
        org.json.JSONArray elements = (org.json.JSONArray) rows_Object.get("elements");
        org.json.JSONObject elements_Object = (org.json.JSONObject) elements.get(0);


        //Check if there are any results, if not return null
        if (! elements_Object.getString("status").equals("OK")){
            System.out.println(elements_Object.getString("error_message"));
            return null;
        }

        //from elements, parse distance and duration in miles and minutes
        org.json.JSONObject distance = (org.json.JSONObject) elements_Object.get("distance");
        org.json.JSONObject duration = (org.json.JSONObject) elements_Object.get("duration");

        //parse and remove all white spaces and characters from the text
        String distance_Text = distance.getString("text");
        distance_Text = distance_Text.replaceAll("[a-zA-Z]", "");
        distance_Text = distance_Text.replaceAll("\\s+","");


        String duration_Text = duration.getString("text");
        //Google maps output can output duration in two different formats, "# hours # mins" or "# mins"
        if(duration_Text.contains("hours")){
            hours = duration_Text.substring(0, duration_Text.indexOf("hours"));
            hours = hours.replaceAll("[^0-9]", "");

            if(duration_Text.contains("mins")) {
                minutes = duration_Text.substring(duration_Text.indexOf("hours")+1,
                        duration_Text.indexOf("mins"));
                minutes = minutes.replaceAll("[^0-9]", "");

            }
            mins = Double.parseDouble(minutes);
            mins += (Double.parseDouble(hours)*60);


        }
        else {
            duration_Text = duration_Text.replaceAll("[^0-9]", "");
            mins = Double.parseDouble(duration_Text);
        }

        System.out.println("Google Calcualting!" + distance_Text + mins);

        return new double[]{Double.parseDouble(distance_Text), mins };
    }
}
