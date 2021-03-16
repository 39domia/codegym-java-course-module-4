package com.controller;

import com.model.Product;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {
    ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/index")
    public String index(@ModelAttribute Product product, Model model) {
        model.addAttribute("products", productService.findAll());
        return "index";
    }

    @GetMapping("/showAdd")
    public String showAdd(@ModelAttribute Product product, Model model) {
        model.addAttribute("product", product);
        return "add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Product product, Model model) {
        productService.add(product);
        model.addAttribute("products", productService.findAll());
        return "index";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findOne(id));
        return "view";
    }

    @GetMapping("/showEdit/{id}")
    public String showEdit(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findOne(id));
        return "update";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Product product, Model model) {
        productService.update(product);
        model.addAttribute("products", productService.findAll());
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id, Model model) {
        productService.delete(id);
        model.addAttribute("products", productService.findAll());
        return "index";
    }
}
