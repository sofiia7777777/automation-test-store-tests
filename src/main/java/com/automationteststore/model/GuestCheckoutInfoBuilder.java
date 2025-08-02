package com.automationteststore.model;

public class GuestCheckoutInfoBuilder {
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String city;
    private String zip;
    private String state;
    private String country;

    public GuestCheckoutInfoBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public GuestCheckoutInfoBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public GuestCheckoutInfoBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public GuestCheckoutInfoBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public GuestCheckoutInfoBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public GuestCheckoutInfoBuilder setZipCode(String zip) {
        this.zip = zip;
        return this;
    }

    public GuestCheckoutInfoBuilder setRegion(String state) {
        this.state = state;
        return this;
    }

    public GuestCheckoutInfoBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    public GuestCheckoutInfo build() {
        return new GuestCheckoutInfo(firstName, lastName, email, address, city, zip, state, country);
    }
}
