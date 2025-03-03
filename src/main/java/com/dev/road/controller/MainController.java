package com.dev.road.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class MainController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/")
    public String mainForm(){
        return "redirect:/index";
    }
}
