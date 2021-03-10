package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Home {
    @GetMapping("home")
    public String showHome(Model model){
        model.addAttribute("mess", "Hello world");
        return "home";
    }
}
