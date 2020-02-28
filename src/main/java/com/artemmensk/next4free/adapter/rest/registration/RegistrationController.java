package com.artemmensk.next4free.adapter.rest.registration;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.artemmensk.next4free.application.registration.RegistrationService;
import com.artemmensk.next4free.domain.BusinessName;
import com.artemmensk.next4free.domain.ClientName;
import com.artemmensk.next4free.domain.Email;
import com.artemmensk.next4free.domain.Password;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping("/client/sign-up")
    public void clientSignUp(@RequestBody @Validated ClientRegistrationRequest request) {
        final Email email = Email.from(request.getEmail());
        final Password password = new Password(request.getPassword());
        final ClientName clientName = ClientName.from(request.getClientName());
        registrationService.registerClient(email, password, clientName);
    }

    @PostMapping("/business/sign-up")
    public void businessSignUp(@RequestBody @Validated BusinessRegistrationRequest request) {
        final Email email = Email.from(request.getEmail());
        final Password password = new Password(request.getPassword());
        final BusinessName businessName = BusinessName.from(request.getBusinessName());
        registrationService.registerBusiness(email, password, businessName);
    }
}
