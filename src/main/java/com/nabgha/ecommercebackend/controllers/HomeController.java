package com.nabgha.ecommercebackend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "Nabgha");
        return "index";
    }

}
// we marked this class as bean: class managed by spring, spring create instance and mange it