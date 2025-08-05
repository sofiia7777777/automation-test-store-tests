package com.automationteststore.model;

public class GuestCheckoutInfo {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String address;
    private final String city;
    private final String region;
    private final String zipCode;
    private final String country;

    public GuestCheckoutInfo(String firstName, String lastName, String email,
                             String address, String city, String zipCode,
                             String region, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.region = region;
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }
}
