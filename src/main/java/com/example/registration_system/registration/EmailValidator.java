package com.example.registration_system.registration;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class EmailValidator implements Predicate<String> {
    /*
     * The class is responsible for checking whether the email is valid*/
    @Override
    public boolean test(String s) {
        // TODO: Regex to validate email
        return true;
    }


}
