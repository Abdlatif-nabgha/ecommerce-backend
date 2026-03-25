package com.nabgha.ecommercebackend.controllers;

import com.nabgha.ecommercebackend.entities.Message;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @RequestMapping("/hello")
    public Message sayHello() {
        return new Message("Hello developers");
    }
}
