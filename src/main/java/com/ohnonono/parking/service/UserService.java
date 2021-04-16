package com.ohnonono.parking.service;

import com.ohnonono.parking.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(String id);

    User saveOrUpdateUser(User user);

    void deleteUserById(String id);
}
