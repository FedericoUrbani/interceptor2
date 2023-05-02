package com.example.interceptor2.controller;

import com.example.interceptor2.entities.Month;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class BasicController {

    @GetMapping
    public String welcome(){
        return "welcome";
    }

}
