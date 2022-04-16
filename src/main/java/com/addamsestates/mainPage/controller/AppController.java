package com.addamsestates.mainPage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class AppController {

    @RequestMapping("/login")
    public String login(){

        return "signin";
    }
}
