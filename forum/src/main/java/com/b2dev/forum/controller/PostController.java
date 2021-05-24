package com.b2dev.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import com.b2dev.forum.entity.Post;
import com.b2dev.forum.entity.Topic;
import com.b2dev.forum.repository.PostRepository;
import com.b2dev.forum.repository.TopicRepository;
import com.b2dev.forum.security.service.UserDetailsServiceImpl;


@RestController
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private TopicRepository topicRepository;

    @PostMapping("/post")
    public Post addPost(@RequestBody Post post) {
        Post postToSave = new Post();
        postToSave.setAuthor(UserDetailsServiceImpl.getCurrentUser());
        postToSave.setContent(post.getContent());
        postToSave.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
        Topic topic = topicRepository.findById(post.getTopic().getId());
        postToSave.setTopic(topic);
        postToSave = postRepository.save(postToSave);
        return postToSave;
    }
}