package com.company.DistanceCalculator;

/**
 * Implementing Strategy pattern for Distance Calculator
 * Strategies: LatLongCalc, GMapCalculator
 */
public interface DistanceCalculator {
    /**
     * Interface for different ways to calculate the distance from one point to another
     * @param str_lat1 Latitude coordinates of origin
     * @param str_lon1 Longitude coordinates of origin
     * @param str_lat2 Latitude coordinates of destination
     * @param str_lon2 Longitude coordinates of destination
     * @return Returns the distance in miles[0], as well as estimated minutes traveled[1]
     * @throws Exception
     */
    public double[] calc(String str_lat1, String str_lon1, String str_lat2, String str_lon2) throws Exception;
}
