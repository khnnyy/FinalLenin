///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.mycompany.webserverlenin;
//
//import java.util.List;
//import org.bson.Document;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
///**
// *
// * @author khanny
// */
//
//@Controller
//@RequestMapping("/")
//public class HomeController {
//    
//    @GetMapping("/home")
//    public String home() {
//        return "home";
//    }
//    
//}


package com.mycompany.webserverlenin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    private final UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public String home(Model model) {
        // Fetch the authenticated user's username
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        // Get the role of the user
        String role = userService.getUserRole(username);
        model.addAttribute("userRole", role);

        return "home";
    }

    // Other methods...
}
