package com.artemmensk.next4free.adapter.rest.authentication;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.artemmensk.next4free.application.authentication.AuthenticationService;
import com.artemmensk.next4free.application.authentication.Token;
import com.artemmensk.next4free.domain.Email;
import com.artemmensk.next4free.domain.Password;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public void login(
            @RequestBody @Validated AuthenticationRequest request,
            HttpServletResponse response) {

        final Email email = Email.from(request.getEmail());
        final Password password = new Password(request.getPassword());

        final Token token = authenticationService.authenticate(email, password);

        setTokenToCookie(response, token);
    }

    private void setTokenToCookie(
            HttpServletResponse response,
            Token token) {
        final Cookie cookie = new Cookie("accessToken", token.getValue());
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
    }
}
