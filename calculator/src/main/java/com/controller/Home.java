package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Home {
    @GetMapping("/home")
    public String home() {
        return "index";
    }

    @GetMapping("/cal")
    public String exe(@RequestParam int one, @RequestParam int two, @RequestParam String func, Model model) {
        switch (func) {
            case "add":
                model.addAttribute("result", (one + two));
                break;
            case "sub":
                model.addAttribute("result", (one - two));
                break;
            case "mul":
                model.addAttribute("result", (one * two));
                break;
            case "div":
                model.addAttribute("result", (one / two));
                break;
        }
        return "index";
    }
}
