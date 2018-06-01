package com.company.CSV;

import com.company.Customer;
import com.company.Recipient;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * CSVHelper is a helper class that handles all procedures with CSV files: reading, writing
 */
public class CSVHelper {

    /**
     * The helper function 'getCustomers' opens the Customer's CV file and parses each line
     * of customer info into a customer object which will be added to a List of Customers.
     * @param filename name of where the customer info file is located
     * @return A list of customers to match
     * @throws FileNotFoundException
     */
    public List<Customer> getCustomers(String filename) throws FileNotFoundException {

        //Create list of customers to add, Read from file
        List<Customer> customers = new ArrayList<>();
        File file = new File(filename);
        Scanner scan = new Scanner(file);
        scan.nextLine();

        //While a customer exists, add them into the list
        while (scan.hasNextLine()) {

            //Read in the info line, and parse
            String line = scan.nextLine();
            if (line.length() != 0) {
                String[] info = line.split(",", 14);
                Customer cust = new Customer(info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7], info[8],
                        info[9], info[10], info[11], info[12], info[13]);

                customers.add(cust);
            }
        }

        //Return list of customers
        scan.close();
        return customers;
    }

    /**
     * The helper function 'getRecipients' behaves the same as the getCustomers function.
     * It opens the Recipients's CV file and parses each line
     * of info into a recipient object which will be added to a List of Recipients
     * @param filename name of where the recipient info file is located
     * @return A list of recipients to match
     * @throws FileNotFoundException
     */
    public List<Recipient> getRecipients(String filename) throws FileNotFoundException {

        //Create list of recipients to add, Read from file
        File file = new File(filename);
        Scanner scan = new Scanner(file);
        scan.nextLine();
        List<Recipient> recipients = new ArrayList<>();

        //While a customer profile exists, add them into the list
        while (scan.hasNextLine()) {

            //Read in the info line strips white space if there is any, and parses into object
            String line = scan.nextLine().replaceAll("\\s", "");
            if (line.length() != 0) {
                String[] info = line.split(",", 19);
                Recipient rec = new Recipient(info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7], info[8],
                        info[9], info[10], info[11], info[12], info[13], info[14], info[15], info[16], info[17], info[18]);

                recipients.add(rec);
            }
        }

        //Return list of customers
        scan.close();
        return recipients;
    }

    /**
     * For each customer, and their match of recipients, use the CSVMaker class to
     * create CSV files as output
     * @param customer  The customer requesting pickup of their donations
     * @param matches   The list of recipients who match the criteria for donating items
     */
    public void outputMatchRecipients(Customer customer, List<Recipient> matches) {

        //Pass file name as well as the customer and the matches to the CSVMaker
        CSVMaker maker = new CSVMaker();
        String fileName = customer.getFirstName() + "_" + customer.getLastName()+"_Matches";
        maker.makeCSVFile(fileName, customer, matches);

    }

}
