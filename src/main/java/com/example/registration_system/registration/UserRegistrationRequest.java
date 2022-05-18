package com.example.registration_system.registration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class UserRegistrationRequest {
    private final String fName;
    private final String LName;
    private final String email;
    private final String password;
}
