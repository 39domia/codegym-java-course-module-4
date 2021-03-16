package com.controller;

import com.service.CustomerService;
import com.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/index")
    public String showList(Model model) {
        model.addAttribute("customers", customerService.findAll());
        return "index";
    }

    @GetMapping("/showAdd")
    public String showAdd(@ModelAttribute Customer customer, Model model) {
        model.addAttribute("customer", customer);
        return "add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Customer customer, Model model){
        customerService.add(customer);
        model.addAttribute("customers", customerService.findAll());
        return "index";
    }


    @GetMapping("/view/{id}")
    public String showInformation(@PathVariable int id, Model model) {
        Customer customer = customerService.findOne(id);
        model.addAttribute("customer", customer);
        return "info";
    }

    @GetMapping("/showEdit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        Customer customer = customerService.findOne(id);
        model.addAttribute("customer", customer);
        return "update";
    }
    @PostMapping("/showEdit/update")
    public String updateCustomer(@ModelAttribute Customer customer, Model model) {
        customerService.update(customer);
        model.addAttribute("customers", customerService.findAll());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        customerService.delete(id);
        model.addAttribute("customers", customerService.findAll());
        return "index";
    }
}
