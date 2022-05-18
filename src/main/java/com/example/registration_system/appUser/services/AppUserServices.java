package com.example.registration_system.appUser.services;

import com.example.registration_system.appUser.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserServices implements UserDetailsService {
    //the class implements the UserDetailsService for security purpose

    private final UserRepository userRepo;
    private final static String USER_NOT_FOUND = "User with email %s Not found";
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepo.findByEmail(email).orElseThrow(()->
                new UsernameNotFoundException(String.format(USER_NOT_FOUND, email)));
    }
}
