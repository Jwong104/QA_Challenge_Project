package com.company.GMapClient;

/**
 * Helps the GMapClient by formatting and creating the URL String for API Call
 */
public class URLMaker {

    /**
     * Delimiter for the uri string '&parameter=Values'
     */
    private static final String PARAM_DELIMITER = "&";

    /**
     * The Base URL and API Key to use
     */
    private String baseURL;
    private String apiKey;

    /**
     * Constructor for URLMaker object, takes in the baseURL and API Key
     * @param baseURL The Base URL to use for API call
     * @param apiKey  The API Key to use for API call
     */
    public URLMaker(String baseURL, String apiKey){
        this.baseURL = baseURL;
        this.apiKey = PARAM_DELIMITER+"key="+apiKey;
    }

    /**
     * Creates the finished URL
     * @param str_lat1 Latitude coordinates of origin
     * @param str_lon1 Longitude coordinates of origin
     * @param str_lat2 Latitude coordinates of destination
     * @param str_lon2 Longitude coordinates of destination
     * @return
     */
    public String getURL(String str_lat1, String str_lon1, String str_lat2, String str_lon2){

        //Formats origin and destination
        String origin = PARAM_DELIMITER + "origins=" + str_lat1 + "," + str_lon1;
        String destination = PARAM_DELIMITER + "destinations=" + str_lat2 + "," + str_lon2;
        StringBuilder builder = new StringBuilder();

        builder = builder.append(this.getBaseURL());
        builder = builder.append(origin);
        builder = builder.append(destination);
        builder = builder.append(this.getApiKey());

        return builder.toString();
    }

    public String getBaseURL() {
        return baseURL;
    }

    public String getApiKey() {
        return apiKey;
    }
}
