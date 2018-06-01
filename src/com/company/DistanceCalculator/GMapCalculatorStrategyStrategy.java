package com.company.DistanceCalculator;

import static com.company.GMapClient.GMapClient.geomatrixDistance;

/**
 * GMapCalculatorStrategyStrategy calls on functions from the GMapClient class for API Calls
 */
public class GMapCalculatorStrategyStrategy implements DistanceCalculatorStrategy {

    /**
     * Calls on the GMapClient class to calculate the distance to travel, as well as the amount of time traveled
     * @param str_lat1 Latitude coordinates of origin
     * @param str_lon1 Longitude coordinates of origin
     * @param str_lat2 Latitude coordinates of destination
     * @param str_lon2 Longitude coordinates of destination
     * @return Returns the distance in miles[0], as well as estimated minutes traveled[1]
     * @throws Exception
     */
    @Override
    public double[] calc(String str_lat1, String str_lon1, String str_lat2, String str_lon2) throws Exception {
        return geomatrixDistance(str_lat1, str_lon1, str_lat2, str_lon2);
    }
}
