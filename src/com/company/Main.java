package com.company;

import com.company.CSV.CSVHelper;
import com.company.DistanceCalculator.CalculateByLatLong;
import com.company.DistanceCalculator.DistanceCalculator;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class Main {

    private static boolean donationMatch(String categories, String restrictions){

        int cInt = Integer.parseInt(categories);
        int rInt = Integer.parseInt(restrictions);
        if((cInt&rInt)==0){return true;}
        return false;
    }

    /*private static boolean timeMatch(){

    }*/

    private static List<Recipient> findMatches(Customer customer, List<Recipient> recipients_list){
        List<Recipient> matches = new ArrayList<Recipient>();

        DistanceCalculator calc = new CalculateByLatLong();

        for(Recipient recipient: recipients_list) {

            if(donationMatch(customer.getCategories(), recipient.getRestrictions())) {
                double distance = calc.calc(customer.getLatitude(), customer.getLongitude(),
                        recipient.getLatitude(), recipient.getLongitude());

                if (distance > 10) {
                    matches.add(recipient);
                }
            }
        }
        return matches;

    }

    
    public static void main(String[] args) {

        CSVHelper csvHelper = new CSVHelper();
        List<Customer> customers = new ArrayList<Customer>();
        List<Recipient> recipients = new ArrayList<Recipient>();
        List<Recipient> matches = new ArrayList<Recipient>();

        try {
            customers = csvHelper.getCustomers("/Users/jasonwong/COGS_3/QA_Coding_Challenge/src/com/company/Customers.csv");
            recipients = csvHelper.getRecipients("/Users/jasonwong/COGS_3/QA_Coding_Challenge/src/com/company/Recipients.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for(Customer customer : customers){

            matches = findMatches(customer, recipients);
            return;
            //csvHelper.outputMatchRecipients(customer, matches);
        }


    }


}
