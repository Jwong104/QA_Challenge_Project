package com.company.DistanceCalculator;

public class LatLongCalculatorStrategyStategy implements DistanceCalculatorStrategy {

    /**
     * Helper function to change from Degrees to Radians
     * @param deg Degrees to change
     * @return Output radians
     */
    private static double degToRad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    /**
     * Helper function to change from Radians to Degrees
     * @param rad Radians to change
     * @return Outputs Degrees
     */
    private static double radToDeg(double rad) {
        return (rad * 180 / Math.PI);
    }

    /**
     * Calculates the distance from one point to another using a straight map coordinate system
     * @param str_lat1 Latitude coordinates of origin
     * @param str_lon1 Longitude coordinates of origin
     * @param str_lat2 Latitude coordinates of destination
     * @param str_lon2 Longitude coordinates of destination
     * @return Returns the distance in miles[0], 0 ~ does not account for travel
     */
    @Override
    public double[] calc(String str_lat1, String str_lon1, String str_lat2, String str_lon2) {

        if(str_lat1 == null || str_lon1 == null || str_lat2 == null || str_lon2 == null){
            throw new IllegalArgumentException("Arguments cannot be null");
        }

        //Pure math of how to calculate from two coordinates into miles
        double lat1 = Double.parseDouble(str_lat1);
        double lon1 = Double.parseDouble(str_lon1);
        double lat2 = Double.parseDouble(str_lat2);
        double lon2 = Double.parseDouble(str_lon2);
        double theta = lon1 - lon2;
        double dist = Math.sin(degToRad(lat1)) * Math.sin(degToRad(lat2)) + Math.cos(degToRad(lat1)) *
                Math.cos(degToRad(lat2)) * Math.cos(degToRad(theta));
        dist = Math.acos(dist);
        dist = radToDeg(dist);
        dist = dist * 60 * 1.1515;
        return new double[]{dist,0.0};
    }
}