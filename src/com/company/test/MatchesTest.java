package com.company.test;

import com.company.Customer;
import com.company.Recipient;
import org.junit.Test;

import static com.company.Matches.Matches.donationMatch;
import static com.company.Matches.Matches.timeMatch;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MatchesTest {

    //
    // Test cases for donationMatch() functions
    //

    /**
     * Test bit 0 of customer for donationMatch function
     * customer bits:   00 00 00
     * recipient bits:  11 11 11
     * Expected Assertion: True
     */
    @Test
    public void testDonationMatchCustBit0(){
        Recipient testRecipient = new Recipient();
        Customer testCustomer = new Customer();
        testCustomer.setCategories("0");
        testRecipient.setRestrictions("63");
        assertTrue(donationMatch(testCustomer.getCategories(), testRecipient.getRestrictions()));

    }

    /**
     * Test bit 1 of customer for donationMatch function
     * customer bits:   01 00 00
     * recipient bits:  10 11 11
     * Expected Assertion: True
     */
    @Test
    public void testDonationMatchCustBit1(){
        Recipient testRecipient = new Recipient();
        Customer testCustomer = new Customer();
        testCustomer.setCategories("16");
        testRecipient.setRestrictions("47");
        assertTrue(donationMatch(testCustomer.getCategories(), testRecipient.getRestrictions()));

    }

    /**
     * Test bit 2 of customer for donationMatch function
     * customer bits:   00 10 00
     * recipient bits:  11 01 11
     * Expected Assertion: True
     */
    @Test
    public void testDonationMatchCustBit2(){
        Recipient testRecipient = new Recipient();
        Customer testCustomer = new Customer();
        testCustomer.setCategories("8");
        testRecipient.setRestrictions("55");
        assertTrue(donationMatch(testCustomer.getCategories(), testRecipient.getRestrictions()));

    }

    /**
     * Test bit 3 of customer for donationMatch function
     * customer bits:   00 01 00
     * recipient bits:  11 10 11
     * Expected Assertion: True
     */
    @Test
    public void testDonationMatchCustBit3(){
        Recipient testRecipient = new Recipient();
        Customer testCustomer = new Customer();
        testCustomer.setCategories("4");
        testRecipient.setRestrictions("59");
        assertTrue(donationMatch(testCustomer.getCategories(), testRecipient.getRestrictions()));

    }

    /**
     * Test bit 4 of customer for donationMatch function
     * customer bits:   00 00 10
     * recipient bits:  11 11 01
     * Expected Assertion: True
     */
    @Test
    public void testDonationMatchCustBit4(){
        Recipient testRecipient = new Recipient();
        Customer testCustomer = new Customer();
        testCustomer.setCategories("2");
        testRecipient.setRestrictions("61");
        assertTrue(donationMatch(testCustomer.getCategories(), testRecipient.getRestrictions()));

    }

    /**
     * Test bit 5 of customer for donationMatch function
     * customer bits:   00 00 01
     * recipient bits:  11 11 10
     * Expected Assertion: True
     */
    @Test
    public void testDonationMatchCustBit5(){
        Recipient testRecipient = new Recipient();
        Customer testCustomer = new Customer();
        testCustomer.setCategories("1");
        testRecipient.setRestrictions("62");
        assertTrue(donationMatch(testCustomer.getCategories(), testRecipient.getRestrictions()));

    }

    /**
     * Test bit 0 of recipient for donationMatch function
     * customer bits:   11 11 11
     * recipient bits:  00 00 00
     * Expected Assertion: True
     */
    @Test
    public void testDonationMatchRecBit0(){
        Recipient testRecipient = new Recipient();
        Customer testCustomer = new Customer();
        testCustomer.setCategories("63");
        testRecipient.setRestrictions("0");
        assertTrue(donationMatch(testCustomer.getCategories(), testRecipient.getRestrictions()));

    }

    /**
     * Test bit 1 of recipient for donationMatch function
     * customer bits:   10 11 11
     * recipient bits:  01 00 00
     * Expected Assertion: True
     */
    @Test
    public void testDonationMatchRecBit1(){
        Recipient testRecipient = new Recipient();
        Customer testCustomer = new Customer();
        testCustomer.setCategories("47");
        testRecipient.setRestrictions("16");
        assertTrue(donationMatch(testCustomer.getCategories(), testRecipient.getRestrictions()));

    }

    /**
     * Test bit 2 of recipient for donationMatch function
     * customer bits:   11 01 11
     * recipient bits:  00 10 00
     * Expected Assertion: True
     */
    @Test
    public void testDonationMatchRecBit2(){
        Recipient testRecipient = new Recipient();
        Customer testCustomer = new Customer();
        testCustomer.setCategories("55");
        testRecipient.setRestrictions("8");
        assertTrue(donationMatch(testCustomer.getCategories(), testRecipient.getRestrictions()));

    }

    /**
     * Test bit 3 of recipient for donationMatch function
     * customer bits:   11 10 11
     * recipient bits:  00 01 00
     * Expected Assertion: True
     */
    @Test
    public void testDonationMatchRecBit3(){
        Recipient testRecipient = new Recipient();
        Customer testCustomer = new Customer();
        testCustomer.setCategories("59");
        testRecipient.setRestrictions("4");
        assertTrue(donationMatch(testCustomer.getCategories(), testRecipient.getRestrictions()));

    }

    /**
     * Test bit 4 of recipient for donationMatch function
     * customer bits:   11 11 01
     * recipient bits:  00 00 10
     * Expected Assertion: True
     */
    @Test
    public void testDonationMatchRecBit4(){
        Recipient testRecipient = new Recipient();
        Customer testCustomer = new Customer();
        testCustomer.setCategories("61");
        testRecipient.setRestrictions("2");
        assertTrue(donationMatch(testCustomer.getCategories(), testRecipient.getRestrictions()));

    }

    /**
     * Test bit 5 of recipient for donationMatch function
     * customer bits:   11 11 10
     * recipient bits:  00 00 01
     * Expected Assertion: True
     */
    @Test
    public void testDonationMatchRecBit5(){
        Recipient testRecipient = new Recipient();
        Customer testCustomer = new Customer();
        testCustomer.setCategories("1");
        testRecipient.setRestrictions("62");
        assertTrue(donationMatch(testCustomer.getCategories(), testRecipient.getRestrictions()));

    }

    /**
     * Testing for scalability of more than 6 bits
     * customer bits:   11 11 11 11
     * recipient bits:  00 00 00 00
     * Expected Assertion: True
     */
    @Test
    public void testDonationMatchRecForScale(){
        Recipient testRecipient = new Recipient();
        Customer testCustomer = new Customer();
        testCustomer.setCategories("255");
        testRecipient.setRestrictions("0");
        assertTrue(donationMatch(testCustomer.getCategories(), testRecipient.getRestrictions()));

    }

    //
    // Test cases for timeMatch() functions
    //

    /**
     * Test case for normal timeMatch behavior
     * dropoff_Times: 1111111111111111
     */
    @Test
    public void testTimeMatchTrue(){
        int[] pickup_Time = new int[]{8,30};
        assertTrue(timeMatch(pickup_Time, 65535, 0));

    }

    /**
     * Test case for estimated Drop off index in function to be out of bounds of 8-24
     * dropoff_Times: 1111111111111111
     * Error -> 0 <= (24:30 + :90) % 24 <= 7
     */
    @Test
    public void testTimeMatchOutOfBounds(){
        int[] pickup_Time = new int[]{24,30};
        assertFalse(timeMatch(pickup_Time, 65535, 90));

    }

    /**
     * Test case for no available drop off times
     */
    @Test
    public void testTimeMatchZeroDropOffTimes(){
        int[] pickup_Time = new int[]{8,30};
        assertFalse(timeMatch(pickup_Time, 0, 90));

    }
    /**
     * Test case for bits and additional driving time
     * dropoffTimes: 49152 = 1100 0000 0000 0000
     */
    @Test
    public void testTimeMatchDropOffTime8to9(){
        int[] pickup_Time = new int[]{8,30};
        assertTrue(timeMatch(pickup_Time, 49152, 0));

    }
    /**
     * Test case for bits and additional driving time
     * dropoffTimes: 12288 = 0011 0000 0000 0000
     */
    @Test
    public void testTimeMatchDropOffTime10to11(){
        int[] pickup_Time = new int[]{10,30};
        assertTrue(timeMatch(pickup_Time, 12288, 0));

    }
    /**
     * Test case for bits and additional driving time
     * dropoffTimes: 3840 = 0000 1100 0000 0000
     */
    @Test
    public void testTimeMatchDropOffTime12to13(){
        int[] pickup_Time = new int[]{12,30};
        assertTrue(timeMatch(pickup_Time, 3072, 0));

    }
    /**
     * Test case for bits and additional driving time
     * dropoffTimes: 768 = 0000 0011 0000 0000
     */
    @Test
    public void testTimeMatchDropOffTime14to15(){
        int[] pickup_Time = new int[]{14,30};
        assertTrue(timeMatch(pickup_Time, 768, 0));

    }
    /**
     * Test case for bits and additional driving time
     * dropoffTimes: 192 = 0000 0000 1100 0000
     */
    @Test
    public void testTimeMatchDropOffTime16to17(){
        int[] pickup_Time = new int[]{16,30};
        assertTrue(timeMatch(pickup_Time, 192, 0));

    }
    /**
     * Test case for bits and additional driving time
     * dropoffTimes: 48 = 0000 0000 0011 0000
     */
    @Test
    public void testTimeMatchDropOffTime18to19(){
        int[] pickup_Time = new int[]{18,30};
        assertTrue(timeMatch(pickup_Time, 48, 0));

    }
    /**
     * Test case for bits and additional driving time
     * dropoffTimes: 12 = 0000 0000 0000 1100
     */
    @Test
    public void testTimeMatchDropOffTime20to21(){
        int[] pickup_Time = new int[]{20,30};
        assertTrue(timeMatch(pickup_Time, 12, 0));

    }
    /**
     * Test case for bits and additional driving time
     * dropoffTimes: 12 = 0000 0000 0000 0011
     */
    @Test
    public void testTimeMatchDropOffTime22to23(){
        int[] pickup_Time = new int[]{22,30};
        assertTrue(timeMatch(pickup_Time, 3, 0));

    }


    /**
     * Test case for bits and additional driving time
     * dropoffTimes: 61440 = 1111000000000000
     */
    @Test
    public void testTimeMatchDropOffTime8to11D(){
        int[] pickup_Time = new int[]{8,30};
        assertTrue(timeMatch(pickup_Time, 61440, 90));

    }
    /**
     * Test case for bits and additional driving time
     * dropoffTimes: 3840 = 0000111100000000
     */
    @Test
    public void testTimeMatchDropOffTime12to15D(){
        int[] pickup_Time = new int[]{12,30};
        assertTrue(timeMatch(pickup_Time, 3840, 90));

    }
    /**
     * Test case for bits and additional driving time
     * dropoffTimes: 240 = 0000000011110000
     */
    @Test
    public void testTimeMatchDropOffTime16to19D(){
        int[] pickup_Time = new int[]{16,30};
        assertTrue(timeMatch(pickup_Time, 240, 90));

    }
    /**
     * Test case for bits and additional driving time
     * dropoffTimes: 3840 = 0000 0000 0000 1111
     */
    @Test
    public void testTimeMatchDropOffTime20to23D(){
        int[] pickup_Time = new int[]{20,30};
        assertTrue(timeMatch(pickup_Time, 15, 90));

    }



}