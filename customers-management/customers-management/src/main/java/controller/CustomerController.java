package controller;

import model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CustomerService;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
public class CustomerController {
    CustomerService customerService = new CustomerService();
    @GetMapping("/index")
    public String showCustomerList(Model model) {
        model.addAttribute("cuslist", customerService.selectAll());
        return "index";
    }

    @GetMapping("/showAdd")
    public String showAdd(@ModelAttribute Customer customer){
        return "add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Customer customer){
        customerService.add(customer);
        return "redirect:/index";
    }

}
