package com.example.cafeproject.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/articles")
    public String articles(){
        return "articles/article_index";
    }

    @GetMapping("/signup")
    public String signup(){
        return "login/loginForm";
    }
}
