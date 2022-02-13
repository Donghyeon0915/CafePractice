package com.example.cafeproject.web.controller;


import com.example.cafeproject.web.dto.article.ArticleDto;
import com.example.cafeproject.web.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/articles")
    public String articles(@RequestParam(value = "userNickname", required = false) String nickname, Model model){
        //@RequestParam @Nullable로도 Null을 받을 수 있다.
        //nickname이 null이 아니라면
        if(!"".equals(nickname)) model.addAttribute("userNickname", nickname);
        List<ArticleDto> articles = articleService.getArticleList();
        model.addAttribute("articles", articles);

        return "/articles/articleIndex";
    }
}
