package com.automationteststore.service;
import com.automationteststore.model.GuestCheckoutInfo;
import com.automationteststore.model.GuestCheckoutInfoBuilder;


public class GuestCheckoutInfoCreator {

    public static GuestCheckoutInfo withDefaultInfo() {
        String firstName = TestDataReader.getTestData("checkout.firstName");
        String lastName = TestDataReader.getTestData("checkout.lastName");
        String email = TestDataReader.getTestData("checkout.email");
        String address = TestDataReader.getTestData("checkout.address");
        String city = TestDataReader.getTestData("checkout.city");
        String zipCode = TestDataReader.getTestData("checkout.zipCode");
        String region = TestDataReader.getTestData("checkout.region");
        String country = TestDataReader.getTestData("checkout.country");

        return new GuestCheckoutInfoBuilder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setAddress(address)
                .setCity(city)
                .setZipCode(zipCode)
                .setRegion(region)
                .setCountry(country)
                .build();
    }
}
