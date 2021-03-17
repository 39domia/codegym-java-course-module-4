package com.controller;

import com.model.Customer;
import com.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/index")
    public String showHome(Model model) {
        model.addAttribute("customers", customerService.findAll());
//        System.out.println(customerService.findAll());
        return "index";
    }

    @GetMapping("/view/{id}")
    public String view(Model model, @PathVariable int id) {
        Customer customer = customerService.findOne(id);
        model.addAttribute("customer", customer);
        return "view";
    }

    @GetMapping("/showAdd")
    public String showAdd( Customer customer, Model model) {
        model.addAttribute("customer", customer);
        return "add";
    }

    @PostMapping("/add")
    public String add(Customer customer) {
        customerService.save(customer);
        return "redirect:/index";
    }

    @GetMapping("/showEdit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        Customer customer = customerService.findOne(id);
        model.addAttribute("customer", customer);
        return "update";
    }

    @PostMapping("/edit")
    public String edit(Customer customer) {
        customerService.update(customer);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        customerService.delete(id);
        return "redirect:/index";
    }
}
