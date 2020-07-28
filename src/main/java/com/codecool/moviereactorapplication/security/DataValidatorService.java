package com.codecool.moviereactorapplication.security;

import com.codecool.moviereactorapplication.model.Gender;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class DataValidatorService {

    private final Pattern specialCharacters = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
    private final Pattern upperCaseLetters = Pattern.compile("[A-Z ]");
    private final Pattern lowerCaseLetters = Pattern.compile("[a-z ]");
    private final Pattern digitsPattern = Pattern.compile("[0-9 ]");

    private final String passwordPattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
    private final String emailPattern = "^(.+)@(.+)$";

    public boolean isValidUsername(String username, List<String> errorList) {
        errorList.clear();
        boolean valid = true;
        if (username.length() < 6) {
            errorList.add("at least 6 characters");
            valid = false;
        }
        if (username.contains(" ")) {
            errorList.add("no whitespaces");
            valid = false;
        }
        return valid;
    }



}

