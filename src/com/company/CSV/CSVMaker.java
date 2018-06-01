package com.company.CSV;

import com.company.Customer;
import com.company.Recipient;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Used to help create/write the CSV files that are outputted
 */
public class CSVMaker {

    /**
     * FILE_HEADER: The initial column names of the CSV File
     * DELIMITER:   CSV Files are delimited by commas
     * NEWLINE:     Each row is separated by a new line character
     */
    private static final String FILE_HEADER = "Type,FirstName,LastName,Street,City,State,Postal,Country," +
            "Email,Phone,DistanceAway";
    private static final String DELIMITER = ",";
    private static final String NEWLINE = "\n";


    /**
     * Function used to create CSV files
     * @param fileName  Name of the file to be written
     * @param customer  Customer information that matches the list of recipients
     * @param matches   The list of Recipients who match the customer
     */
    public void makeCSVFile(String fileName, Customer customer, List<Recipient> matches) {

        //Location of where files will be written to
        File file = new File("out/production/QA_Challenge_Project/com/company/Output_Matches/"+fileName);
        FileWriter fileWriter = null;

        try {

            //Append to the head of the file the column names of the CSV file
            fileWriter = new FileWriter(file);
            fileWriter.append(FILE_HEADER);
            fileWriter.append(NEWLINE);

            //Append Customer information
            fileWriter.append("Customer" + DELIMITER);
            fileWriter.append(customer.getFirstName() + DELIMITER);
            fileWriter.append(customer.getLastName() + DELIMITER);
            fileWriter.append(customer.getStreet() + DELIMITER);
            fileWriter.append(customer.getCity() + DELIMITER);
            fileWriter.append(customer.getState() + DELIMITER);
            fileWriter.append(customer.getPostal() + DELIMITER);
            fileWriter.append(customer.getCountry() + DELIMITER);
            fileWriter.append(customer.getEmail() + DELIMITER);
            fileWriter.append(customer.getPhone() + DELIMITER);
            fileWriter.append("0" + NEWLINE);

            //Append the matches under the customer
            for(Recipient recipient : matches){

                fileWriter.append("Recipient" + DELIMITER);
                fileWriter.append(recipient.getFirstName() + DELIMITER);
                fileWriter.append(recipient.getLastName() + DELIMITER);
                fileWriter.append(recipient.getStreet() + DELIMITER);
                fileWriter.append(recipient.getCity() + DELIMITER);
                fileWriter.append(recipient.getState() + DELIMITER);
                fileWriter.append(recipient.getPostal() + DELIMITER);
                fileWriter.append(recipient.getCountry() + DELIMITER);
                fileWriter.append(recipient.getEmail() + DELIMITER);
                fileWriter.append(recipient.getPhone() + DELIMITER);
                fileWriter.append(String.valueOf(recipient.getDistanceToCustomer()) + NEWLINE);

            }
            System.out.println("Success CSV File has been made for "+ customer.getFirstName());

        } catch (Exception e) {
            System.out.println("Error in CSVMaker!");
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.flush();
                    fileWriter.close();
                }
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter!");
                e.printStackTrace();
            }

        }
    }

}
