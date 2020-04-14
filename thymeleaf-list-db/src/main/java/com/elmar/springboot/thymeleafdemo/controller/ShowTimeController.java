package com.elmar.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowTimeController {
    //create mapping for "/hello", to show server time. For educational purposes.
    @RequestMapping("/time")
    public String sayHello(Model model){

        model.addAttribute("theDate", new java.util.Date());
        return "welcome-time";
    }
}
