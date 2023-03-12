package com.ecommerce.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginForm(Model model){
        model.addAttribute("title", "Login");
        return "login";
    }
   }
