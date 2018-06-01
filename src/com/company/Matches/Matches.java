package com.company.Matches;

import com.company.Customer;
import com.company.DistanceCalculator.DistanceCalculator;
import com.company.DistanceCalculator.GMapCalculator;
import com.company.DistanceCalculator.LatLongCalculator;
import com.company.Recipient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Matches {

    /**
     * MAXDISTANCE: the 10 mile radius recipients can be matched with customers
     * MINUTES: 60 minutes within 1 hour
     */
    private static final double MAXDISTANCE = 10.0;
    private static final double MINUTES = 60;

    /**
     * This function compares the categories and restrictions between Customer's
     * and recipients. The Customer's category bits show the types of items they will be donating.
     * While the Recipient's restriction bits show the categories of food they cannot accept.
     * Function should scale as more bits are added to the categories/restrictions,
     * up to the limit of the amount of bits an int can hold (32).
     * Bit 0: Raw Meat
     * Bit 1: Dairy
     * Bit 2: Seafood
     * Bit 3: Hot Prepared
     * Bit 4: Cold Prepared
     * Bit 5: Frozen
     * An '&' bit wise operator is used here. As the only case that turns false is when a customer
     * wants to donate a type of food that is restricted at a recipients.
     *
     * @param categories   Customer's type of donations in bits
     * @param restrictions Recipients's accepted donations in bits
     * @return True if the donation categories match between the two parties
     */
    public static boolean donationMatch(String categories, String restrictions) {

        int cInt = Integer.parseInt(categories);
        int rInt = Integer.parseInt(restrictions);
        if ((cInt & rInt) == 0) {
            return true;
        }
        return false;
    }

    /**
     * The timeMatch function is used to ensure that at the same time food is picked up,
     * the recipient will be active during their normal business hours.
     * This is the bitmap of the dropoff_Times provided by the recipients. Bit(0) = 8-9am, and etc.
     * bit_Map = {8,9}, {9,10}, {10,11}, {11,12}, {12,13}, {13,14}, {14,15}, {15,16},
     * {16,17}, {17,18}, {18,19}, {19,20}, {20,21}, {21,22}, {22,23}, {23,24}
     *
     * @param pickup_Time   The earliest time for pickup, 1st element is hour, 2nd element is minutes
     * @param dropoff_Times The time range interval in hours of when food can be dropped off,
     *                      bit map example above
     * @param driving_Time  An estimated driving time (in minutes) will be added towards the
     *                      calculated dropoff_Range
     * @return A boolean, True being the times of both parties match, and False if they don't.
     */
    public static boolean timeMatch(int[] pickup_Time, int dropoff_Times, int driving_Time) {

        // pickup_Time[0], pickup_Time[1] are the hours and minutes of the
        // earliest_Time available for pickup
        // while the dropoff_Hour is one hour added to it
        int earliest_Time = pickup_Time[0];
        int dropoff_Hour = 1;

        //Minutes and driving time are accounted into the dropoff_Hour
        //increment latest_time, if driving time plus estimated minutes exceeded one hour
        driving_Time += pickup_Time[1];
        if ((driving_Time / MINUTES) > 0) { dropoff_Hour += (int) (driving_Time / MINUTES); }

        //dropoff_Hour is pickup_Time[0] plus time it will take to dropoff the delivery
        //Need to make sure the hour to drop it off is not within 1AM - 7AM, otherwise return false
        dropoff_Hour = (dropoff_Hour + pickup_Time[0]) % 24;
        if (0 <= dropoff_Hour && dropoff_Hour <= 7) { return false; }

        //Calculating index of bit comparison, if the pickup time is less than index 0
        //then default value will be 0
        int pickup_Index = (earliest_Time - 8);
        if(pickup_Index < 0){ pickup_Index = 0; }
        int dropoff_Index = (dropoff_Hour - 8);

        //Padding zeros into integer binary string conversion
        String leadingZeros = "0000000000000000";
        String dropoff_Range = leadingZeros + Integer.toBinaryString(dropoff_Times);
        dropoff_Range = dropoff_Range.substring(dropoff_Range.length() - 16, dropoff_Range.length());

        //Comparing only the pickup_Index and latest expected dropoff_Index
        while (pickup_Index < dropoff_Index + 1) {
            //Checking each bitmap interval if recipient is open
            if (dropoff_Range.charAt(pickup_Index) == '0') { return false; }
            pickup_Index++;
        }

        return true;

    }

    /**
     * The find matches will check with each customer if any of the recipients within the list are a match.
     * The first filter is a 10 mile radius, then from those within a 10 mile radius, it then checks if
     * the items donated are accepted by the recipient facility and if the facility is open during time of
     * pickup/dropoff.
     *
     * @param customer        The customer who is wishing to donate
     * @param recipients_list The list of participating recipients accepting food
     * @return A list of all the matches found, unsorted.
     */
    public static List<Recipient> findMatches(Customer customer, List<Recipient> recipients_list, int strategy) throws Exception {

        //The List of matches to return and the DistanceCalculator for distance away
        List<Recipient> matches = new ArrayList<>();
        DistanceCalculator distanceCalculator;
        double[] distNDriveTime;

        if(strategy == 0) { distanceCalculator = new LatLongCalculator(); }
        else{ distanceCalculator = new GMapCalculator(); }

        //For each recipient in the list, check if the customer's items can be delivered to them
        for (Recipient recipient : recipients_list) {

            //Check distance between the customer and recipient is less than 10 miles
            distNDriveTime = distanceCalculator.calc(customer.getLatitude(), customer.getLongitude(),
                    recipient.getLatitude(), recipient.getLongitude());

            if ( distNDriveTime != null && distNDriveTime[0] <= MAXDISTANCE ) {

                //Calculate pickup and dropoff times of customer and recipient
                int dayNum = customer.getDayOfPickUp();
                int[] pickup_Time = customer.getTimeOfPickUp();
                int dropoff_Time = Integer.parseInt(recipient.getDayOfPickUp(dayNum));

                //Check if recipient can accept the donated food items and if times match
                if (donationMatch(customer.getCategories(), recipient.getRestrictions())
                        && timeMatch(pickup_Time, dropoff_Time, (int)distNDriveTime[1])) {

                    //Matched! Set distance of recipient and add to list of matches
                    recipient.setDistanceToCustomer(distNDriveTime[0]);
                    matches.add(recipient);
                }


            }
        }

        //Return the list of matches
        return matches;

    }


    /**
     * Sort the list of matches with the first match being the closest from the location of the customer,
     * and the last match being the farthest away.
     *
     * @param matches The list of recipients who match the customer's donation items and time availability
     * @return A list of the sorted matches
     */
    public static ArrayList<Recipient> sortMatches(List<Recipient> matches) {


        //Convert Arraylist into array and sorts based on distance away from customer
        Object[] matched = matches.toArray();
        Arrays.sort(matched);

        //Convert back to ArrayList
        Recipient[] sorted = Arrays.asList(matched).toArray(new Recipient[matched.length]);
        ArrayList<Recipient> sortedMatches = new ArrayList<>(Arrays.asList(sorted));
        return sortedMatches;
    }

}