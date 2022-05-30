package com.example.registration_system.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path =  "apis/v1/registration")//changing the default path for the apis
@AllArgsConstructor
public class UserRegistrationController {
    private UserRegistrationService registrationService;

    //registration method
    @PostMapping
    public String registration(@RequestBody UserRegistrationRequest registrationRequest){
        return registrationService.register(registrationRequest);
    }

}
