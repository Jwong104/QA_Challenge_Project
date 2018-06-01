# QA_Challenge_Project

Java Version 1.8.0_151
This coding challenge/project was built on IntelliJ IDEA!

I. File list
------------
CSVHelper.java		                Helper class to read and write CSV files
CSVMaker.java		                Helper class to handle and create CSV files
DistanceCalculator.java		        Calculator implementation
DistanceCalculatorStrategy.java     Class to instantiate strategy pattern for calculator
GMapCalculatorStrategy.java		    Calculator strategy to calculate between two points using Google Maps
LatLongCalculatorStratgy.java	    Calculator strategy to calculate between two points in miles (Map coordinate system)
GMapClient.java 	                Helper Class to make Google Maps Distance Matrix API Call
URLMaker.java		                Helper Class to create URL for API Call
Matches.java		                Implementation logic of customer recipient matching
CustomerTest.java		            Test file for Customer member functions
GMapClientTest.java		            Test file for GMalClient member functions
MatchesTest.java		            Test file for Matches member functions
RecipientTest.java		            Test file for Recipient member functions
README			                    This file
Challenge README.txt		        Instructions for the challenge
CSV Content Descriptions	        Gives more context into CSV rows such as categories/restrictions
Customer.java		                Customer object implementation
Customer.csv                        Customer profile/information CSV file
Development Process.txt             My development process of this project
Main.java                           Main function of project
Recipient.java                      Recipient object implementation
Recipient.csv                       Recipient profile/information CSV file
JSON-java-master                    Java Package downloaded to handle JSON Parsing

Output of matches will be located in: out/production/QA_Challenge_Project/com/company/Output_Matches

II. How to run
_______________
Have a customer csv file called Customer.csv and a recipient csv file called Recipient.csv within
the 'run' folder.

Entering '0' calculates distance based on the Map Coordinate system in miles
Entering '1' will calculate distance and driving time by calling on the Google Maps API

To Run the program, go to the run folder in the terminal and execute this command
'java -jar QA_Challenge_Project.jar'

Caution: Google maps API has a limit on the amount of calls per day!

