package com.api.relivro.dto;

import com.api.relivro.model.UserModel;


public record UserDetails(Long id, String name, String username, String email, String password, String city, String state, String birthdate) {

    public UserDetails(UserModel user) {
        this(user.getId(), user.getUsername(), user.getName(), user.getEmail(), user.getPassword(), user.getCity(), user.getState(), user.getBirthdate());
    }
}

