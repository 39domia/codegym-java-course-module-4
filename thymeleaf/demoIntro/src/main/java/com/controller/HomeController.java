package com.controller;

import com.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/index")
    public String showHomepage(Model model){
        List<User> userList = new ArrayList<>();
        userList.add(new User(0, "A", "B", 1));
        userList.add(new User(0, "A1", "B1", 2));
        userList.add(new User(0, "A2", "B2", 1));
        userList.add(new User(0, "A3", "B3", 2));
        userList.add(new User(0, "A4", "B4", 3));
        model.addAttribute("userList", userList);
        return "index2";
    }
}
