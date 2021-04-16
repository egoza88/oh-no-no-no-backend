package com.ohnonono.parking.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

@Getter
@Setter
@Document(collection = "users")
public class User {

    @Id
    @NonNull()
    private String id;
    private String firstname;
    private String surname;
    private String email;

    public User() {
    }

    public User(String firstname, String surname, String email) {
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
    }
}
