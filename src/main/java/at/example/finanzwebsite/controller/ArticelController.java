package at.example.finanzwebsite.controller;


import at.example.finanzwebsite.entity.Article;
import at.example.finanzwebsite.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ArticelController {

    private ArticleService articleService = new ArticleService();

    @Autowired
    public ArticelController(ArticleService articleService){
        this.articleService = articleService;
    }



    @GetMapping("article")
    public List<Article> readAll(){
        return articleService.getAllArticle();
    }
    @GetMapping("/{id}")
    public Article read(@PathVariable int id){
        return articleService.getArticle(id);
    }

    @PostMapping
    public void addArticle(@RequestBody Article article){
        articleService.addArticle(article);
    }
    @PutMapping
    public void updateArticle(@RequestBody Article article, @RequestBody String newText){
        articleService.updateArticle(article, newText);
    }
    @DeleteMapping
    public void deleteArticle(@RequestBody Article article){
        articleService.deleteArticle(article);
    }











}
