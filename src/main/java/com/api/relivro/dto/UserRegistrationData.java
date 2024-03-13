package com.api.relivro.dto;

import java.time.YearMonth;

public record UserRegistrationData(String name, String username, String email, String password, String city, String state, YearMonth birthdate
) {
}
