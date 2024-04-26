package com.dev.road.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller("/admin")
public class AdminController {

    @GetMapping("/dashboard")
    public String admin(){

        return "admin";
    }

}
