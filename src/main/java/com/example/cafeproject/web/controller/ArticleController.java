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
    public String articles(@RequestParam(value = "userNickname", required = false) String nickname, Model model){
        //@RequestParam @Nullable로도 Null을 받을 수 있다.
        //nickname이 null이 아니라면
        if(!"".equals(nickname)) {
            log.info("닉네임 들어옴 {}", nickname);
            model.addAttribute("userNickname", nickname);
        }
        List<ArticleDto> articles = articleService.getArticleList();
        model.addAttribute("articles", articles);

        return "/articles/articleIndex";
    }
    @PostMapping("/articles/view")
    public String viewArticle(@RequestBody ViewDto dto, RedirectAttributes redirectAttributes){
        redirectAttributes.addAttribute("userNickname", dto.getUserNickname());
        log.info(dto.getUserNickname() + "요청됨");

        return "redirect:/articles/" + dto.getArticleId();
    }

    @GetMapping("/articles/{id}")
    public String viewArticle(@PathVariable Long id,
                              @RequestParam(value = "userNickname") String nickname, Model model){
        log.info("id = " + id);
        ArticleDto article = articleService.getArticle(id);

        model.addAttribute("article", article);
        model.addAttribute("userNickname", nickname);

        return "/articles/articleView";
    }
}
