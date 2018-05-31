package com.company.test;

import com.company.Customer;
import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {

    private static Customer testCustomer = new Customer();


    @Test
    public void testGetDayOfPickUpMonday(){
        testCustomer.setPickupAt("2018-05-14T16:00:00-08:00");
        testCustomer.setTimeZoneId("America/Los_Angeles");
        int dayNum = testCustomer.getDayOfPickUp();
        int expected = 1;
        Assert.assertEquals(expected, dayNum);

    }

    @Test
    public void testGetDayOfPickUpTuesday(){
        testCustomer.setPickupAt("2018-05-15T16:00:00-08:00");
        testCustomer.setTimeZoneId("America/Los_Angeles");
        int dayNum = testCustomer.getDayOfPickUp();
        int expected = 2;
        Assert.assertEquals(expected, dayNum);

    }

    @Test
    public void testGetDayOfPickUpWednesday(){
        testCustomer.setPickupAt("2018-05-16T16:00:00-08:00");
        testCustomer.setTimeZoneId("America/Los_Angeles");
        int dayNum = testCustomer.getDayOfPickUp();
        int expected = 3;
        Assert.assertEquals(expected, dayNum);

    }

    @Test
    public void testGetDayOfPickUpThursday(){
        testCustomer.setPickupAt("2018-05-17T16:00:00-08:00");
        testCustomer.setTimeZoneId("America/Los_Angeles");
        int dayNum = testCustomer.getDayOfPickUp();
        int expected = 4;
        Assert.assertEquals(expected, dayNum);

    }

    @Test
    public void testGetDayOfPickUpFriday(){
        testCustomer.setPickupAt("2018-05-18T16:00:00-08:00");
        testCustomer.setTimeZoneId("America/Los_Angeles");
        int dayNum = testCustomer.getDayOfPickUp();
        int expected = 5;
        Assert.assertEquals(expected, dayNum);

    }

    @Test
    public void testGetDayOfPickUpSaturday(){
        testCustomer.setPickupAt("2018-05-19T16:00:00-08:00");
        testCustomer.setTimeZoneId("America/Los_Angeles");
        int dayNum = testCustomer.getDayOfPickUp();
        int expected = 6;
        Assert.assertEquals(expected, dayNum);

    }

    @Test
    public void testGetDayOfPickUpSunday(){
        testCustomer.setPickupAt("2018-05-20T16:00:00-08:00");
        testCustomer.setTimeZoneId("America/Los_Angeles");
        int dayNum = testCustomer.getDayOfPickUp();
        int expected = 7;
        Assert.assertEquals(expected, dayNum);

    }

    @Test
    public void testGetTimeOfPickU8(){
        testCustomer.setPickupAt("2018-05-20T08:00:00-08:00");
        testCustomer.setTimeZoneId("America/Los_Angeles");
        int[] time = testCustomer.getTimeOfPickUp();
        int[] expected = {8,0};
        Assert.assertArrayEquals(expected, time);

    }

}