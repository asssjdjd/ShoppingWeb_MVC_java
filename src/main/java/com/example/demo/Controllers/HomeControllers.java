package com.example.demo.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeControllers {

    @GetMapping({"", "/"})
    public String home() {
        return "index";
    }

    @GetMapping("/login")
    public String Login() {
        return "login";
    }

    @GetMapping("/register")
    public String Register() {
        return "register";
    }

    @GetMapping("/products")
    public String Products(){ return "product";}

    @GetMapping("/product")
    public String Product(){return "view_product";}


}
