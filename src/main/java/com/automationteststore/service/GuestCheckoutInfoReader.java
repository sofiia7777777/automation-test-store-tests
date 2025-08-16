package com.automationteststore.service;

import com.automationteststore.model.GuestCheckoutInfo;
import com.automationteststore.utils.CredentialsProvider;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class GuestCheckoutInfoReader {

    private static final Map<String, GuestCheckoutInfo> data;

    static {
        ObjectMapper mapper = new ObjectMapper();
        try {
            data = mapper.readValue(
                    new File("src/test/resources/checkoutData.json"),
                    new TypeReference<>() {}
            );
        } catch (IOException e) {
            throw new RuntimeException("Failed to read checkoutData.json", e);
        }
    }

    public static GuestCheckoutInfo getUserCheckoutInfo() {
        String username = CredentialsProvider.getUsername();
        return data.get(username);
    }

}
