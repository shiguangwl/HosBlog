package com.xxhoz.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.xxhoz.Utils.ResJsonUtils;
import com.xxhoz.pojo.HosArticles;
import com.xxhoz.service.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RestController
@RequestMapping("/api")
public class TTT {
    @Autowired
    ArticlesService articlesService;


    @RequestMapping(value = "/ttt",method = RequestMethod.POST)
    public String test(@RequestBody HosArticles article) throws JsonProcessingException {
        int i = articlesService.addArticle(article);
        System.out.println(article);
        return ResJsonUtils.Tojson(article);
    }
}
