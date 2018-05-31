package com.company;

import com.company.CSV.CSVHelper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import static com.company.Matches.Matches.findMatches;
import static com.company.Matches.Matches.sortMatches;


public class Main {

    /**
     * CUST_PATH:  Customer CSV filename path
     * REC_PATH: Recipient CSV filename path
     */
    private static final String CUST_PATH = "out/production/QA_Challenge_Project/com/company/Customers.csv";
    private static final String REC_PATH = "out/production/QA_Challenge_Project/com/company/Recipients.csv";

    public static void main(String[] args) {


        CSVHelper csvHelper = new CSVHelper();
        List<Customer> customers = new ArrayList<>();
        List<Recipient> recipients = new ArrayList<>();
        List<Recipient> matches;

        try {

            customers = csvHelper.getCustomers(CUST_PATH);
            recipients = csvHelper.getRecipients(REC_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        /*
        Scanner navigator = new Scanner(System.in);
        System.out.println("Welcome! I am Navi, your assistant for today!");
        System.out.println("If you haven't already, go ahead and look at my README and my purpose.");
        System.out.println("But for now let's start creating those delivery orders.");

        //sort by decending or ascending
        //sort using strictly lat and lng, or total distance traveled using maps
        System.out.print("Give me a few quantums while I create your matches now! ");

        */

        int index =0;
        for (Customer customer : customers) {
            matches = findMatches(customer, recipients);
            matches = sortMatches(matches);
            csvHelper.outputMatchRecipients(customer, matches);

            /*
            System.out.println(customer);

            for(Recipient recipient : matches){

                System.out.println(recipient);
                //System.out.println(match.getValue());
            }*/

            //index++;
            //if(index == 3 ){
                return;
            //}
            //System.out.println();
            //System.out.println(matches);

            //return;

            //csvHelper.outputMatchRecipients(customer, matches);
        }


    }


}
