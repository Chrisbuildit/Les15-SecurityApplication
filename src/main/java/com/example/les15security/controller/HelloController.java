package com.example.les15security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayHello() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth.getPrincipal() instanceof UserDetails) {
            UserDetails ud = (UserDetails) auth.getPrincipal();
            return "Hello " + ud.getUsername();
        }
        else {
            return "Hello stranger!";
        }
    }

    @GetMapping("/secret")
    public String tellSecret() {
        return "This is very secret...";
    }
}
