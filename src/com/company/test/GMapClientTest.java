package com.company.test;

import com.company.GMapClient.GMapClient;
import org.junit.Test;

import static org.junit.Assert.*;

public class GMapClientTest {

    /**
     * Testing for duration of drive to include hours and mins
     */
    @Test
    public void testGeomatrixDistanceHoursMins() throws Exception {
        double[] ret = GMapClient.geomatrixDistance("38.96768", "-122.32831", "37.76768", "-122.32831");
        double[] expected = new double[]{112.0,125.0,};

        if(ret != null){ assertArrayEquals(expected, ret, 1.0); }



    }

    /**
     * Testing for duration of drive to only have mins
     * @throws Exception
     */
    @Test
    public void testGeomatrixDistanceMins() throws Exception {
        double[] ret = GMapClient.geomatrixDistance("37.96768", "-122.32831", "37.76768", "-122.32831");
        double[] expected = new double[]{18.6,32.0};
        if(ret != null){ assertArrayEquals(expected, ret, 1.0); }
    }
}