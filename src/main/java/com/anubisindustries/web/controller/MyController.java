package com.anubisindustries.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author altrax
 */
@Controller
public class MyController {

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", "anubis industries");
        return "home";
    }
}
