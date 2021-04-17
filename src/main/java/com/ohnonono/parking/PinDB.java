package com.ohnonono.parking;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class PinDB {
    private final Map<String, String> myDB = new HashMap<>(); // :D sorry for that...I didn't sleep already for 20 hours..

    public boolean hasPin(String username) {
        return myDB.containsKey(username);
    }

    public PinDB() {
        myDB.put("team1.uzivatel4", "1743");
        myDB.put("team1.uzivatel9", "1234");
        myDB.put("team1.uzivatel16", "7583");
    }

    public String getPin(String username) {
        return myDB.get(username);
    }

    public String generatePin(String name) {
        String pin;
        do {
            SecureRandom random = new SecureRandom();
            int num = random.nextInt(10000);
            pin = String.format("%04d", num);
        }while (myDB.containsKey(pin));

        myDB.put(name, pin);
        return pin;
    }
}
