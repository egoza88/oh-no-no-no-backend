package com.ohnonono.parking;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class PinDB {
    private Map<String, String> myDB = new HashMap<>(); // :D sorry for that...I didn't sleep already for 20 hours..

    public boolean hasPin(String token) {
        return myDB.containsKey(token);
    }

    public String getPin(String token) {
        return myDB.get(token);
    }

    public String generatePin(String token) {
        String pin;
        do {
            SecureRandom random = new SecureRandom();
            int num = random.nextInt(10000);
            pin = String.format("%04d", num);
        }while (myDB.containsKey(pin));

        myDB.put(token, pin);
        return pin;
    }
}
