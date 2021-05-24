package com.b2dev.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.b2dev.forum.entity.Topic;
import com.b2dev.forum.repository.TopicRepository;


@RestController
@RequestMapping("topic")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @GetMapping
    public Page<Topic> getTopics(Pageable pageable) {
        return topicRepository.findAll(pageable);
    }
}