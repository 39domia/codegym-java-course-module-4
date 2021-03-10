package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @GetMapping("/index")
    public String showIndex() {
        return "index";
    }

    @PostMapping("/convert")
    public String convert(@RequestParam int usd, Model model) {
        int vnd = usd * 22000;
        model.addAttribute("vnd", vnd);
        return "index2";
    }
}
