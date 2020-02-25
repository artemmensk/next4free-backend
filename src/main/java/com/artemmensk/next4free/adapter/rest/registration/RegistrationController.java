package com.artemmensk.next4free.adapter.rest.registration;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.artemmensk.next4free.application.registration.RegistrationService;
import com.artemmensk.next4free.domain.Email;
import com.artemmensk.next4free.domain.Password;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/sign-up")
    public void signUp(@RequestBody @Validated RegistrationRequest request) {
        final Email email = Email.from(request.getEmail());
        final Password password = new Password(request.getPassword());
        registrationService.register(email, password);
    }

}
