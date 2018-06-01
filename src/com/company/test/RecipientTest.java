package com.company.test;

import com.company.Customer;
import com.company.Recipient;
import org.junit.Assert;
import org.junit.Test;

public class RecipientTest {



    @Test
    public void testGetDayOfPickUpMonday(){

        Recipient testRecipient = new Recipient();
        testRecipient.setMonday("001");
        String expected = testRecipient.getMonday();

        Customer testCustomer = new Customer();
        testCustomer.setPickupAt("2018-05-14T16:00:00-08:00");
        testCustomer.setTimeZoneId("America/Los_Angeles");
        int dayNum = testCustomer.getDayOfPickUp();

        String testBits = testRecipient.getDayOfPickUp(dayNum);
        Assert.assertEquals(expected, testBits);

    }
    @Test
    public void testGetDayOfPickUpTuesday(){
        Recipient testRecipient = new Recipient();
        testRecipient.setTuesday("010");
        String expected = testRecipient.getTuesday();

        Customer testCustomer = new Customer();
        testCustomer.setPickupAt("2018-05-15T16:00:00-08:00");
        testCustomer.setTimeZoneId("America/Los_Angeles");
        int dayNum = testCustomer.getDayOfPickUp();

        String testBits = testRecipient.getDayOfPickUp(dayNum);
        Assert.assertEquals(expected, testBits);

    }
    @Test
    public void testGetDayOfPickUpWednesday(){
        Recipient testRecipient = new Recipient();
        testRecipient.setWednesday("011");
        String expected = testRecipient.getWednesday();

        Customer testCustomer = new Customer();
        testCustomer.setPickupAt("2018-05-16T16:00:00-08:00");
        testCustomer.setTimeZoneId("America/Los_Angeles");
        int dayNum = testCustomer.getDayOfPickUp();

        String testBits = testRecipient.getDayOfPickUp(dayNum);
        Assert.assertEquals(expected, testBits);

    }
    @Test
    public void testGetDayOfPickUpThursday(){
        Recipient testRecipient = new Recipient();
        testRecipient.setThursday("100");
        String expected = testRecipient.getThursday();

        Customer testCustomer = new Customer();
        testCustomer.setPickupAt("2018-05-17T16:00:00-08:00");
        testCustomer.setTimeZoneId("America/Los_Angeles");
        int dayNum = testCustomer.getDayOfPickUp();

        String testBits = testRecipient.getDayOfPickUp(dayNum);
        Assert.assertEquals(expected, testBits);

    }
    @Test
    public void testGetDayOfPickUpFriday(){
        Recipient testRecipient = new Recipient();
        testRecipient.setFriday("101");
        String expected = testRecipient.getFriday();

        Customer testCustomer = new Customer();
        testCustomer.setPickupAt("2018-05-18T16:00:00-08:00");
        testCustomer.setTimeZoneId("America/Los_Angeles");
        int dayNum = testCustomer.getDayOfPickUp();

        String testBits = testRecipient.getDayOfPickUp(dayNum);
        Assert.assertEquals(expected, testBits);

    }
    @Test
    public void testGetDayOfPickUpSaturday(){
        Recipient testRecipient = new Recipient();
        testRecipient.setSaturday("110");
        String expected = testRecipient.getSaturday();

        Customer testCustomer = new Customer();
        testCustomer.setPickupAt("2018-05-19T16:00:00-08:00");
        testCustomer.setTimeZoneId("America/Los_Angeles");
        int dayNum = testCustomer.getDayOfPickUp();

        String testBits = testRecipient.getDayOfPickUp(6);
        Assert.assertEquals(expected, testBits);

    }
    @Test
    public void testGetDayOfPickUpSunday(){
        Recipient testRecipient = new Recipient();
        testRecipient.setSunday("000");
        String expected = testRecipient.getSunday();

        Customer testCustomer = new Customer();
        testCustomer.setPickupAt("2018-05-20T16:00:00-08:00");
        testCustomer.setTimeZoneId("America/Los_Angeles");
        int dayNum = testCustomer.getDayOfPickUp();

        String testBits = testRecipient.getDayOfPickUp(dayNum);
        Assert.assertEquals(expected, testBits);

    }


}