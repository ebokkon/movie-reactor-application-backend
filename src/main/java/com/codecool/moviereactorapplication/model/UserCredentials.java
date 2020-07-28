package com.codecool.moviereactorapplication.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCredentials {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Gender gender;
}
