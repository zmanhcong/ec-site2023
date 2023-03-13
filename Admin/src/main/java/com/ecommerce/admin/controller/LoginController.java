package com.ecommerce.admin.controller;

import com.ecommerce.library.dto.AdminDto;
import com.ecommerce.library.model.Admin;
import com.ecommerce.library.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.JMoleculesConverters;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.net.http.HttpClient;

@Controller
public class LoginController {

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    AdminService adminService;
    @GetMapping("/login")
    public String loginForm(Model model){
        model.addAttribute("title", "Login");
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("adminDto", new AdminDto());
        return "register";
    }

    @GetMapping("/forgot-password")
    public String forgotpassword(){
        return "forgot-password";
    }

    @PostMapping("/register")
    public String addNewAdmin(@Valid @ModelAttribute("adminDto") AdminDto adminDto,
                              BindingResult result,
                              Model model,
                              HttpSession session,
                              RedirectAttributes redirectAttributes){
        try{
            session.removeAttribute("message");
            if (result.hasErrors()){
                model.addAttribute("adminDto", adminDto);
//                result.toString();
                return "register";
            }
            String username = adminDto.getUsername();
            Admin admin = adminService.findByUsername(username);
            if (admin != null){
                model.addAttribute("adminDto", adminDto);
                session.setAttribute("message", "Your email has been register!");
                System.out.println("Your email has been register!");
                return "register";
            }
            if (adminDto.getPassword().equals(adminDto.getRepeatPassword())){
                adminDto.setPassword(passwordEncoder.encode(adminDto.getPassword()));
                adminService.save(adminDto);
                session.setAttribute("message", "Register successfully");
                model.addAttribute("adminDto", adminDto);
                System.out.println("Register successfully");
            }else {
                model.addAttribute("adminDto", adminDto);
                session.setAttribute("message", "Confirm your repead password");
                System.out.println("passNotSame_error");
                return "register";
            }


        }catch (Exception e){
            e.printStackTrace(); //show log when hit Exception
            session.setAttribute("message", "Server is error, please try again!!");
        }
        return "register";
    }

   }
