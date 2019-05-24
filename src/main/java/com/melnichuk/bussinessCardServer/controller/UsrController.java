package com.melnichuk.bussinessCardServer.controller;

import com.melnichuk.bussinessCardServer.document.Usr;
import com.melnichuk.bussinessCardServer.service.UserDetailsServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsrController {

    private final UserDetailsServiceImpl userDetailsService;

    public UsrController(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/sign-up")
    private void signUp(@RequestBody Usr usr) {
        userDetailsService.addUser(usr);
    }
}
