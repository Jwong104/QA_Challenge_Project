package com.company.test;

import com.company.Customer;
import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {


    /**
     * Test customer getDayOfPickUp to return 1 - Monday
     */
    @Test
    public void testGetDayOfPickUpMonday(){
        Customer testCustomer = new Customer();
        testCustomer.setPickupAt("2018-05-14T16:00:00-08:00");
        testCustomer.setTimeZoneId("America/Los_Angeles");
        int dayNum = testCustomer.getDayOfPickUp();
        int expected = 1;
        Assert.assertEquals(expected, dayNum);

    }

    /**
     * Test customer getDayOfPickUp to return 2 - Tuesday
     */
    @Test
    public void testGetDayOfPickUpTuesday(){
        Customer testCustomer = new Customer();
        testCustomer.setPickupAt("2018-05-15T16:00:00-08:00");
        testCustomer.setTimeZoneId("America/Los_Angeles");
        int dayNum = testCustomer.getDayOfPickUp();
        int expected = 2;
        Assert.assertEquals(expected, dayNum);

    }

    /**
     * Test customer getDayOfPickUp to return 3 - Wednesday
     */
    @Test
    public void testGetDayOfPickUpWednesday(){
        Customer testCustomer = new Customer();
        testCustomer.setPickupAt("2018-05-16T16:00:00-08:00");
        testCustomer.setTimeZoneId("America/Los_Angeles");
        int dayNum = testCustomer.getDayOfPickUp();
        int expected = 3;
        Assert.assertEquals(expected, dayNum);

    }

    /**
     * Test customer getDayOfPickUp to return 4 - Thursday
     */
    @Test
    public void testGetDayOfPickUpThursday(){
        Customer testCustomer = new Customer();
        testCustomer.setPickupAt("2018-05-17T16:00:00-08:00");
        testCustomer.setTimeZoneId("America/Los_Angeles");
        int dayNum = testCustomer.getDayOfPickUp();
        int expected = 4;
        Assert.assertEquals(expected, dayNum);

    }

    /**
     * Test customer getDayOfPickUp to return 5 - Friday
     */
    @Test
    public void testGetDayOfPickUpFriday(){
        Customer testCustomer = new Customer();
        testCustomer.setPickupAt("2018-05-18T16:00:00-08:00");
        testCustomer.setTimeZoneId("America/Los_Angeles");
        int dayNum = testCustomer.getDayOfPickUp();
        int expected = 5;
        Assert.assertEquals(expected, dayNum);

    }

    /**
     * Test customer getDayOfPickUp to return 6 - Saturday
     */
    @Test
    public void testGetDayOfPickUpSaturday(){
        Customer testCustomer = new Customer();
        testCustomer.setPickupAt("2018-05-19T16:00:00-08:00");
        testCustomer.setTimeZoneId("America/Los_Angeles");
        int dayNum = testCustomer.getDayOfPickUp();
        int expected = 6;
        Assert.assertEquals(expected, dayNum);

    }

    /**
     * Test customer getDayOfPickUp to return 7 - Sunday
     */
    @Test
    public void testGetDayOfPickUpSunday(){
        Customer testCustomer = new Customer();
        testCustomer.setPickupAt("2018-05-20T16:00:00-08:00");
        testCustomer.setTimeZoneId("America/Los_Angeles");
        int dayNum = testCustomer.getDayOfPickUp();
        int expected = 7;
        Assert.assertEquals(expected, dayNum);

    }

    /**
     * Decided not to make further tests for this as all of the code was
     * library calls that return int values between 0-23 for horus and int for minutes
     */
    @Test
    public void testGetTimeOfPickU8(){
        Customer testCustomer = new Customer();
        testCustomer.setPickupAt("2018-05-20T08:00:00-08:00");
        testCustomer.setTimeZoneId("America/Los_Angeles");
        int[] time = testCustomer.getTimeOfPickUp();
        int[] expected = {8,0};
        Assert.assertArrayEquals(expected, time);

    }

}