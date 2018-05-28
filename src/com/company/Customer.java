package com.company;

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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostal() {
        return postal;
    }

    public String getCountry() {
        return country;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getCategories() {
        return categories;
    }

    public String getPickupAt() {
        return pickupAt;
    }

    public String getTimeZoneId() {
        return timeZoneId;
    }
}


