package com.example.cafeproject.web.apiController;

import com.example.cafeproject.web.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentApiController {

    @Autowired
    private CommentService commentService;


}
