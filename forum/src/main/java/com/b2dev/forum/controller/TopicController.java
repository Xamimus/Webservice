package com.b2dev.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.b2dev.forum.entity.Topic;
import com.b2dev.forum.repository.TopicRepository;

import java.util.Optional;


@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @ResponseBody
    @GetMapping
    public Page<Topic> getTopics(Pageable pageable) {
        return topicRepository.findAll(pageable);
    }

    @ResponseBody
    @GetMapping("{id}")
    public Topic getTopicById(final @PathVariable("id") String topicId) {
        try {
            Optional<Topic> topic = topicRepository.findById(Integer.valueOf(topicId));
            return topic.get();
        } catch (Exception e) {
            return null;
        }
    }
}
