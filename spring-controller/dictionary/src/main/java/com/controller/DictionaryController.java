package com.controller;

import com.model.Dictionary;
import com.service.DictionaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    DictionaryService dictionaryService = new DictionaryService();

    @GetMapping("/index")
    public String showIndex() {
        return "index";
    }

    @PostMapping("/search")
    public String search(@RequestParam String english, Model model) {
        String result = dictionaryService.search(english);
        if (result !=null){
            model.addAttribute("result", result);
        }
        else {
            model.addAttribute("result", "Not found");
        }
        return "result";
    }
}
