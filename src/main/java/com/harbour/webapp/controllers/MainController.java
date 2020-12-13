package com.harbour.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/homepage")
    public String homePage(){
        return "homepage";
    }

}
