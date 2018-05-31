package com.company.test;

import com.company.Recipient;
import org.junit.Assert;
import org.junit.Test;

public class RecipientTest {

    private static Recipient testRecipient = new Recipient();

    @Test
    public void testGetDayOfPickUpMonday(){
        testRecipient.setMonday("001");
        String expected = testRecipient.getMonday();
        String testBits = testRecipient.getDayOfPickUp(1);
        Assert.assertEquals(expected, testBits);

    }
    @Test
    public void testGetDayOfPickUpTuesday(){
        testRecipient.setTuesday("010");
        String expected = testRecipient.getTuesday();
        String testBits = testRecipient.getDayOfPickUp(2);
        Assert.assertEquals(expected, testBits);

    }
    @Test
    public void testGetDayOfPickUpWednesday(){
        testRecipient.setWednesday("011");
        String expected = testRecipient.getWednesday();
        String testBits = testRecipient.getDayOfPickUp(3);
        Assert.assertEquals(expected, testBits);

    }
    @Test
    public void testGetDayOfPickUpThursday(){
        testRecipient.setThursday("100");
        String expected = testRecipient.getThursday();
        String testBits = testRecipient.getDayOfPickUp(4);
        Assert.assertEquals(expected, testBits);

    }
    @Test
    public void testGetDayOfPickUpFriday(){
        testRecipient.setFriday("101");
        String expected = testRecipient.getFriday();
        String testBits = testRecipient.getDayOfPickUp(5);
        Assert.assertEquals(expected, testBits);

    }
    @Test
    public void testGetDayOfPickUpSaturday(){
        testRecipient.setSaturday("110");
        String expected = testRecipient.getSaturday();
        String testBits = testRecipient.getDayOfPickUp(6);
        Assert.assertEquals(expected, testBits);

    }
    @Test
    public void testGetDayOfPickUpSunday(){
        testRecipient.setSunday("000");
        String expected = testRecipient.getSunday();
        String testBits = testRecipient.getDayOfPickUp(7);
        Assert.assertEquals(expected, testBits);

    }


}