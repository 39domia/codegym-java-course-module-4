package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class SpiceController {
    @GetMapping("/home")
    public String index() {
        return "index";
    }

    @GetMapping("/spice")
    public String exe(@RequestParam(defaultValue = "not found") String[] a, Model model) {
//        if (a.length == 0) {
//            model.addAttribute("mess", "Not found");
//        } else {
        model.addAttribute("mess", Arrays.toString(a));
//        }
        return "result";
    }
}
