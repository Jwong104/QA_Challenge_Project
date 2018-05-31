package com.company;

/**
 * Class Customer used to hold information of each customer, implements Comparable for sorting
 */
public class Recipient implements Comparable<Recipient> {

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
    private String restrictions;
    private String sunday;
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;
    private String saturday;
    private Double distanceToCustomer;

    /**
     * All of the information of customer is provided by CSV File thus this constructor
     * is used to parse and hold that information
     * @param firstName     First name of recipient
     * @param lastName      Last name of recipient
     * @param street        Street of recipient
     * @param city          City of recipient
     * @param state         State of recipient
     * @param postal        Postal address of recipient
     * @param country       Country of recipient
     * @param email         E-mail address of recipient
     * @param phone         Phone number of recipient
     * @param latitude      Latitude coordinates of recipient
     * @param longitude     Longitude coordinates of recipient
     * @param restrictions  Restriction of food categories accepted for donation
     * @param sunday        Hours of operation on Sunday
     * @param monday        Hours of operation on Monday
     * @param tuesday       Hours of operation on Tuesday
     * @param wednesday     Hours of operation on Wednesday
     * @param friday        Hours of operation on Friday
     * @param saturday      Hours of operation on Saturday
     */
    public Recipient(String firstName, String lastName, String street, String city, String state, String postal,
                     String country, String email, String phone, String latitude, String longitude, String restrictions,
                     String sunday, String monday, String tuesday, String wednesday, String thursday, String friday,
                     String saturday) {
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
        this.restrictions = restrictions;
        this.sunday = sunday;
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
    }

    public Recipient(){}

    /**
     * Override compareTo function for Comparable interface sorting using Arrays
     * @return Int value from comparison of recipient distance
     */
    @Override
    public int compareTo(Recipient recipient) {
        System.out.println("IN");
        int compareDistance = (int) (recipient.getDistanceToCustomer() * 1000);
        //return (int)(compareDistance - (this.getDistanceToCustomer() * 1000));
        return (int)((this.getDistanceToCustomer() * 1000) - compareDistance);
    }

    /**
     * Override toString method to print out Recipient information
     * @return String representing Recipient object information
     */
    @Override
    public String toString() {
        return "Recipient{" +
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
                ", restrictions='" + restrictions + '\'' +
                ", sunday='" + sunday + '\'' +
                ", monday='" + monday + '\'' +
                ", tuesday='" + tuesday + '\'' +
                ", wednesday='" + wednesday + '\'' +
                ", thursday='" + thursday + '\'' +
                ", friday='" + friday + '\'' +
                ", saturday='" + saturday + '\'' +
                ", distanceToCustomer=" + distanceToCustomer +
                '}';
    }

    /**
     * Receives an integer value from Customer representing days of the week.
     * From the LocalDateTime and ZonedDateTime object, the integer values of the week
     * start from 1-7 representing Monday - Sunday.
     * @param dayNum Integer value 1-7 representing the integer value of Monday - Sunday
     * @return Bit String of the hours of operation of the recipient
     */
    public String getDayOfPickUp(int dayNum) {

        //String array of the days of the week
        String[] strDays = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        //Mod dayNum by 7 translates it to the index of strDays
        dayNum = dayNum % 7;
        String day = strDays[dayNum];

        //Return the corresponding day of operation of the recipient
        switch (day) {
            case "Monday":
                return this.getMonday();
            case "Tuesday":
                return this.getTuesday();
            case "Wednesday":
                return this.getWednesday();
            case "Thursday":
                return this.getThursday();
            case "Friday":
                return this.getFriday();
            case "Saturday":
                return this.getSaturday();
            case "Sunday":
                return this.getSunday();

        }

        //Return null if error
        return null;

    }

    /**
     * Set distanceToCustomer of Recipient
     * @param distance The distance to set
     */
    public void setDistanceToCustomer(Double distance) {
        this.distanceToCustomer = distance;
    }

    /**
     * Get distanceToCustomer from Recipient
     * @return The distance value Recipient is away from Customer
     */
    public Double getDistanceToCustomer() {
        return distanceToCustomer;
    }

    /**
     * Get firstName of Recipient
     * @return firstName member variable of Recipient
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get lastName of Recipient
     * @return lastName member variable of Recipient
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Get the Street address of Recipient location
     * @return street member variable of Recipient
     */
    public String getStreet() {
        return street;
    }

    /**
     * Get the City of Recipient location
     * @return city member variable of Recipient
     */
    public String getCity() {
        return city;
    }

    /**
     * Get the State of Recipient location
     * @return state member variable of Recipient
     */
    public String getState() {
        return state;
    }

    /**
     * Get the Postal address of Recipient location
     * @return postal member variable of Recipient
     */
    public String getPostal() {
        return postal;
    }

    /**
     * Get the Country of Recipient location
     * @return coutry member variable of Recipient
     */
    public String getCountry() {
        return country;
    }

    /**
     * Get the E-mail address of Recipient
     * @return email member variable of Recipient
     */
    public String getEmail() {
        return email;
    }

    /**
     * Get the Phone number of Recipient
     * @return phone member variable of Recipient
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Get the Latitude coordinates of Recipient
     * @return latitude member variable of Recipient
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * Get the Longitude coordinates of Recipient
     * @return longitude member variable of Recipient
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * Get the restriction on the items that cannot be donated
     * @return Bit string representing the items that cannot be donated
     */
    public String getRestrictions() {
        return restrictions;
    }

    /**
     * Get the hours of operation on Sunday
     * @return Bit string representing the hours of operation
     */
    public String getSunday() {
        return sunday;
    }

    /**
     * Get the hours of operation on Monday
     * @return Bit string representing the hours of operation
     */
    public String getMonday() {
        return monday;
    }

    /**
     * Get the hours of operation on Tuesday
     * @return Bit string representing the hours of operation
     */
    public String getTuesday() {
        return tuesday;
    }

    /**
     * Get the hours of operation on Wednesday
     * @return Bit string representing the hours of operation
     */
    public String getWednesday() {
        return wednesday;
    }

    /**
     * Get the hours of operation on Thursday
     * @return Bit string representing the hours of operation
     */
    public String getThursday() {
        return thursday;
    }

    /**
     * Get the hours of operation on Friday
     * @return Bit string representing the hours of operation
     */
    public String getFriday() {
        return friday;
    }

    /**
     * Get the hours of operation on Saturday
     * @return Bit string representing the hours of operation
     */
    public String getSaturday() {
        return saturday;
    }

    /**
     * Set the First Name of the Recipient
     * @param firstName String value of Recipient's First Name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Set the Last Name of the Recipient
     * @param lastName String value of Recipient's Last Name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Set the Street address of the Recipient
     * @param street String value of Recipient's street address
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Set the City of Recipient location
     * @param city String value of Recipient's city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Set the State of Recipient location
     * @param state String value of Recipient's state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Set the Postal address of Recipient location
     * @param postal String value of Recipient's postal address
     */
    public void setPostal(String postal) {
        this.postal = postal;
    }

    /**
     * Set the Country of Recipient location
     * @param country String value of Recipient's country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Set the Email address of Recipient location
     * @param email String value of Recipient's e-mail address
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Set the Phone number of Recipient location
     * @param phone String value of Recipient's phone number
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Set the Latitude coordinates of Recipient's location
     * @param latitude String value of Recipient's latitude coordinates
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * Set the Longitude coordinates of Recipient's location
     * @param longitude String value of Recipient's longitude coordinates
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    /**
     * Set the Restrictions Recipients have on the items of food accepted for donation
     * @param restrictions Bit string value of Recipient's restrictions
     */
    public void setRestrictions(String restrictions) {
        this.restrictions = restrictions;
    }

    /**
     * Sets the hours of operation on Sunday
     * @param sunday Bit String value representing hours of operation
     */
    public void setSunday(String sunday) {
        this.sunday = sunday;
    }

    /**
     * Sets the hours of operation on Monday
     * @param monday Bit String value representing hours of operation
     */
    public void setMonday(String monday) {
        this.monday = monday;
    }

    /**
     * Sets the hours of operation on Tuesday
     * @param tuesday Bit String value representing hours of operation
     */
    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    /**
     * Sets the hours of operation on Wednesday
     * @param wednesday Bit String value representing hours of operation
     */
    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    /**
     * Sets the hours of operation on Thursday
     * @param thursday Bit String value representing hours of operation
     */
    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    /**
     * Sets the hours of operation on Friday
     * @param friday Bit String value representing hours of operation
     */
    public void setFriday(String friday) {
        this.friday = friday;
    }

    /**
     * Sets the hours of operation on Saturday
     * @param saturday Bit String value representing hours of operation
     */
    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }
}
