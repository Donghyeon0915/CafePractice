package com.example.cafeproject.web.controller;


import com.example.cafeproject.web.dto.ViewDto;
import com.example.cafeproject.web.dto.article.ArticleDto;
import com.example.cafeproject.web.entity.Article;
import com.example.cafeproject.web.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/articles")
    public String articles(@CookieValue(name = "loginUser", required = false) String nickname, Model model){
        //@RequestParam @Nullable로도 Null을 받을 수 있다.
        //nickname이 null이 아니라면
        if(!"".equals(nickname)) model.addAttribute("userNickname", nickname);

        List<ArticleDto> articles = articleService.getArticleList();
        model.addAttribute("articles", articles);

        return "/articles/articleIndex";
    }

    @GetMapping("/articles/{id}")
    public String viewArticle(@PathVariable Long id,
                              @CookieValue(name = "loginUser") String nickname, Model model){
        log.info("id = " + id);
        ArticleDto article = articleService.getArticle(id);

        log.info(article.toString());
        model.addAttribute("articleDto", article);
        model.addAttribute("userNickname", nickname);

        return "/articles/articleView";
    }
}
