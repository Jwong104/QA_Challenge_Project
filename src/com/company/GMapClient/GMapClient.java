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
     * to travel, as well as the amount of time traveled
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

        // Calls on API through URL
        Scanner scan = new Scanner(url.openStream());
        String json_Str = "";
        while (scan.hasNext())
            json_Str += scan.nextLine();
        scan.close();

        // build a JSON object of the entire JSON File
        org.json.JSONObject obj = new org.json.JSONObject(json_Str);
        if (! obj.getString("status").equals("OK"))
            return null;

        // Get the rows array from the original JSON Object
        org.json.JSONArray rows = (org.json.JSONArray) obj.get("rows");
        org.json.JSONObject rows_Object = (org.json.JSONObject) rows.get(0);

        //Get the elements array from the rows array
        org.json.JSONArray elements = (org.json.JSONArray) rows_Object.get("elements");
        org.json.JSONObject distance_Object = (org.json.JSONObject) elements.get(0);

        //Check if there are any results, if not return null
        if (! distance_Object.getString("status").equals("OK"))
            return null;

        //from elements, parse distance and duration in miles and minutes
        org.json.JSONObject distance = (org.json.JSONObject) distance_Object.get("distance");
        org.json.JSONObject duration = (org.json.JSONObject) distance_Object.get("duration");

        //parse and remove all white spaces and characters from the text
        String miles = distance.getString("text").replaceAll("[^0-9]", "");
        String min = duration.getString("text").replaceAll("[^0-9]", "");;

        return new double[]{Integer.parseInt(miles), Integer.parseInt(min)};
    }
}
