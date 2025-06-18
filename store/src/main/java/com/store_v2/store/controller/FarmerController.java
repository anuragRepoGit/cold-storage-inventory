package com.store_v2.store.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FarmerController {

    @GetMapping("/")
    public String greet(){
        return "Hello motherfucker";
    }
}
