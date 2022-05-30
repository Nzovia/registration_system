package com.example.registration_system.appUser.services;

import com.example.registration_system.appUser.AppUser;
import com.example.registration_system.appUser.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AppUserServices implements UserDetailsService {
    //the class implements the UserDetailsService for security purpose

    private final UserRepository userRepo;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final static String USER_NOT_FOUND = "User with email %s Not found";
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepo.findByEmail(email).orElseThrow(()->
                new UsernameNotFoundException(String.format(USER_NOT_FOUND, email)));
    }

    //method for user signup
    public String SignUpUser(AppUser appUser){

        //first check if the user exists
        boolean userExists = userRepo
                .findByEmail(appUser.getEmail())
                .isPresent();
        if(userExists){
            throw new IllegalStateException("email already registered");
        }
        String passwordEncoded = bCryptPasswordEncoder.encode(appUser.getPassword());
        appUser.setPassword(passwordEncoded);

        //registering user
        userRepo.save(appUser);

        // TODO: Send Confirmation token to the user
        return "User registered";
    }
}
