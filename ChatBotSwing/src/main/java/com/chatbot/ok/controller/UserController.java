package com.chatbot.ok.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping(value = "/api/user")
    public String user(){
        return "Welcome";
    }
}
