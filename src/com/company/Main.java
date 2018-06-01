package com.company;

import com.company.CSV.CSVHelper;
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


    /**
     * Helper function to ensure User only puts in 0s or 1s
     * 0 for Map Coordinate System calculations
     * 1 for Google Map Calculations
     * @param navigator Scanner to take user input
     * @return int value representing the type of calculations to use
     */
    private static int userChoice(Scanner navigator){

        String input;
        while(navigator.hasNext()){
            input = navigator.nextLine().replaceAll("\\s", "");
            if(input.equals("1")){
                return 1;
            }
            else if(input.equals("0")){
                return 0;
            }
            System.out.println("Oops, wrong input! Try only putting in a '0' or '1' !");
            System.out.println("By Map Coordinate System (0), or Google Map driving system (1)?");
        }
        return 0;

    }

    public static void main(String[] args) throws Exception {

        //Parser for CSV Files, Customer list to accumulate, Recipient list to accumulate
        CSVHelper csvHelper = new CSVHelper();
        List<Customer> customers = new ArrayList<>();
        List<Recipient> recipients = new ArrayList<>();
        List<Recipient> matches;

        //Calculation strategy
        int strategy;


        //Populate customer and recipient list
        customers = csvHelper.getCustomers(CUST_PATH);
        recipients = csvHelper.getRecipients(REC_PATH);

        //Start user interaction and ask for calculation strategy
        Scanner navigator = new Scanner(System.in);
        System.out.println("Welcome! I am Navi, your assistant for today!");
        System.out.println("If you haven't already, go ahead and look at my README and my purpose.");
        System.out.println("But for now let's start creating those delivery orders.");
        System.out.println("How do you want to computer your matches?");
        System.out.println("By Map Coordinate System (0), or Google Map driving system (1)?");
        strategy = userChoice(navigator);
        System.out.println("Give me a few quantums while I create your matches now! ");

        //Create and output matches into new CSV Files
        for (Customer customer : customers) {
            matches = findMatches(customer, recipients, strategy);
            matches = sortMatches(matches);
            csvHelper.outputMatchRecipients(customer, matches);
        }

        System.out.println("Done! Files will be located here: " +
                "out/production/QA_Challenge_Project/com/company/Output_Matches");

    }


}
