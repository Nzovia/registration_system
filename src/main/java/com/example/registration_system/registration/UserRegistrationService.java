package com.example.registration_system.registration;

import com.example.registration_system.appUser.AppUser;
import com.example.registration_system.appUser.AppUserRole;
import com.example.registration_system.appUser.services.AppUserServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserRegistrationService {

    private final EmailValidator emailValidator;
    private final AppUserServices appUserServices;
    public String register(UserRegistrationRequest registrationRequest) {
        boolean isValidEmail = emailValidator.test(registrationRequest.getEmail());

        if(!isValidEmail){
            throw new IllegalStateException("Invalid email");
        }
        return  appUserServices.SignUpUser(
                new AppUser(
                        registrationRequest.getFName(),
                        registrationRequest.getLName(),
                        registrationRequest.getEmail(),
                        registrationRequest.getPassword(),
                        AppUserRole.USER

                )
        );
    }
}
