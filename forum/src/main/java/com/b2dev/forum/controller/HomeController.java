package com.b2dev.forum.controller;

import com.b2dev.forum.payload.response.HomeResponse;
import com.b2dev.forum.repository.CategoryRepository;
import com.b2dev.forum.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("home")
public class HomeController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TopicRepository topicRepository;

    /*
    Récupère toutes les catégories et les 5 derniers topics enregistrés
     */
    @GetMapping
    public HomeResponse getHome() {
        HomeResponse response = new HomeResponse();
        response.setCategories(categoryRepository.findAll());
        response.setTopics(topicRepository.findTop5ByOrderByIdDesc());
        return response;
    }
}
