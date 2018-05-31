package com.company;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

/**
 * Class Customer used to hold information of each customer
 */
public class Customer {

    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String postal;
    private String country;
    private String email;
    private String phone;
    private String latitude;
    private String longitude;
    private String categories;
    private String pickupAt;
    private String timeZoneId;

    /**
     * All of the information of customer is provided by CSV File thus this constructor
     * is used to parse and hold that information
     * @param firstName     First name of customer
     * @param lastName      Last name of customer
     * @param street        Street of customer residence
     * @param city          City of customer residence
     * @param state         State of customer residence
     * @param postal        Postal address of customer residence
     * @param country       Country of customer residence
     * @param email         E-mail address of customer
     * @param phone         Phone number of customer
     * @param latitude      Latitude coordinates of customer
     * @param longitude     Longitude coordinates of customer
     * @param categories    Categories of the items being donated
     * @param pickupAt      Pick up request time of customer
     * @param timeZoneId    Time zone ID of customer residence
     */
    public Customer(String firstName, String lastName, String street, String city, String state, String postal,
                    String country, String email, String phone, String latitude, String longitude, String categories,
                    String pickupAt, String timeZoneId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postal = postal;
        this.country = country;
        this.email = email;
        this.phone = phone;
        this.latitude = latitude;
        this.longitude = longitude;
        this.categories = categories;
        this.pickupAt = pickupAt;
        this.timeZoneId = timeZoneId;
    }

    public Customer(){}

    /**
     * Override toString method to print out Customer information
     * @return String representing Customer object information
     */
    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postal='" + postal + '\'' +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", categories='" + categories + '\'' +
                ", pickupAt='" + pickupAt + '\'' +
                ", timeZoneId='" + timeZoneId + '\'' +
                '}';
    }

    /**
     * Calculates the integer value of the day of the week in the range 1-7 corresponding to
     * Monday - Sunday
     * @return Integer value of the day of the week
     */
    public int getDayOfPickUp() {

        //Formats the date for parse and is used to parse into LocalDateTime Object
        DateTimeFormatter format = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        LocalDateTime day = LocalDateTime.parse(this.getPickupAt(), format);

        //Calculates the offset in the time using the TimeZoneID and LocalDateTime
        ZoneId dayZone = ZoneId.of(this.getTimeZoneId());
        ZonedDateTime timeOfDate = ZonedDateTime.of(day, dayZone);

        //returns int value corresponding to day of week
        return timeOfDate.getDayOfWeek().getValue();

    }

    /**
     * Calculates the time of the day, taking into consideration time zone offsets
     * @return [0] = Hour of pickUp, [1] = minute of pickUp
     */
    public int[] getTimeOfPickUp() {

        //Formats the date for parse and is used to parse into LocalDateTime Object
        DateTimeFormatter format = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
        LocalDateTime day = LocalDateTime.parse(this.getPickupAt(), format);

        //Calculates the offset in the time using the TimeZoneID and LocalDateTime
        ZoneId dayZone = ZoneId.of(this.getTimeZoneId());
        ZonedDateTime timeOfDate = ZonedDateTime.of(day, dayZone);

        //returns int array of the hour and minutes of pick up
        return new int[]{timeOfDate.getHour(), timeOfDate.getMinute()};

    }

    /**
     * Get firstName of Customer
     * @return firstName member variable of Customer
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get lastName of Customer
     * @return lastName member variable of Customer
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Get the Street address of Customer location
     * @return street member variable of Customer
     */
    public String getStreet() {
        return street;
    }

    /**
     * Get the City of Customer location
     * @return city member variable of Customer
     */
    public String getCity() {
        return city;
    }

    /**
     * Get the State of Customer location
     * @return state member variable of Customer
     */
    public String getState() {
        return state;
    }

    /**
     * Get the Postal address of Customer location
     * @return postal member variable of Customer
     */
    public String getPostal() {
        return postal;
    }

    /**
     * Get the Country of Customer location
     * @return coutry member variable of Customer
     */
    public String getCountry() {
        return country;
    }

    /**
     * Get the E-mail address of Customer
     * @return email member variable of Customer
     */
    public String getEmail() {
        return email;
    }

    /**
     * Get the Phone number of Customer
     * @return phone member variable of Customer
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Get the Latitude coordinates of Customer
     * @return latitude member variable of Customer
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * Get the Longitude coordinates of Customer
     * @return longitude member variable of Customer
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * Get the categories of the items being donated
     * @return Bit string representing categories being donated
     */
    public String getCategories() {
        return categories;
    }

    /**
     * Get estimated Pick Up time of items
     * @return pickup member variable - time location formatted in ISO 8601
     */
    public String getPickupAt() {
        return pickupAt;
    }

    /**
     * Get the timeZone of the Customer's location
     * @return timeZoneID member variable of Customer in IANA zone format
     */
    public String getTimeZoneId() {
        return timeZoneId;
    }

    /**
     * Set the First Name of the Customer
     * @param firstName String value of Customer's First Name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Set the Last Name of the Customer
     * @param lastName String value of Customer's Last Name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Set the Street address of the Customer
     * @param street String value of Customer's street address
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Set the City of Customer location
     * @param city String value of Customer's city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Set the State of Customer location
     * @param state String value of Customer's state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Set the Postal address of Customer location
     * @param postal String value of Customer's postal address
     */
    public void setPostal(String postal) {
        this.postal = postal;
    }

    /**
     * Set the Country of Customer location
     * @param country String value of Customer's country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Set the Email address of Customer location
     * @param email String value of Customer's e-mail address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Set the Phone number of Customer location
     * @param phone String value of Customer's phone number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Set the Latitude coordinates of Customer's location
     * @param latitude String value of Customer's latitude coordinates
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * Set the Longitude coordinates of Customer's location
     * @param longitude String value of Customer's longitude coordinates
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * Set the Customer's categories of items for donation
     * @param categories Bit string value of categories of items
     */
    public void setCategories(String categories) {
        this.categories = categories;
    }

    /**
     * Set estimated pick up time of items for donation
     * @param pickupAt String value of time formatted in ISO 8601
     */
    public void setPickupAt(String pickupAt) {
        this.pickupAt = pickupAt;
    }

    /**
     * Set Time Zone ID of Customer location
     * @param timeZoneId String value of the Time Zone in IANA zone format
     */
    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
    }
}


