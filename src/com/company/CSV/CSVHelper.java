package com.company.CSV;

import com.company.Customer;
import com.company.Recipient;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVHelper {
    public List<Customer> getCustomers(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scan = new Scanner(file);
        scan.nextLine();
        List<Customer> customers = new ArrayList<Customer>();
        while(scan.hasNextLine()){

            String line = scan.nextLine();
            String[] info = line.split(",", 14);
            Customer cust = new Customer(info[0], info[1],info[2],info[3],info[4],info[5],info[6],info[7],info[8],
                    info[9], info[10], info[11], info[12], info[13]);

            customers.add(cust);
        }

        scan.close();
        return customers;
    }
    public List<Recipient> getRecipients(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scan = new Scanner(file);
        scan.nextLine();
        List<Recipient> recipients = new ArrayList<Recipient>();
        while(scan.hasNextLine()){

            String line = scan.nextLine();
            String[] info = line.split(",", 19);
            Recipient rec = new Recipient(info[0], info[1],info[2],info[3],info[4],info[5],info[6],info[7],info[8],
                    info[9], info[10], info[11], info[12], info[13], info[14], info[15], info[16], info[17], info[18]);

            recipients.add(rec);
        }

        scan.close();
        return recipients;
    }
    public void outputMatchRecipients(Customer customer, List<Recipient> matches){
        String filename = new String(customer.getFirstName() + customer.getLastName());


    }

}
