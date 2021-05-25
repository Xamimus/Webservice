package com.b2dev.forum.controller;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.b2dev.forum.entity.EnumRole;
import com.b2dev.forum.entity.Post;
import com.b2dev.forum.entity.Topic;
import com.b2dev.forum.entity.Report;
import com.b2dev.forum.repository.PostRepository;
import com.b2dev.forum.repository.ReportRepository;
import com.b2dev.forum.repository.TopicRepository;
import com.b2dev.forum.security.service.UserDetailsServiceImpl;


@RestController
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private ReportRepository reportRepository;

    @GetMapping
    public Page<Post> getPosts(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @PostMapping("/post")
    public ResponseEntity<Post> addPost(@RequestBody Post post) {
        if (UserDetailsServiceImpl.getCurrentUser() != null) {
            Post postToSave = new Post();
            postToSave.setAuthor(UserDetailsServiceImpl.getCurrentUser());
            postToSave.setContent(post.getContent());
            postToSave.setCreatedAt(new GregorianCalendar(2020, Calendar.JANUARY, 1).getTime());
            Topic topic = topicRepository.findById(post.getTopic().getId());
            postToSave.setTopic(topic);
            return ResponseEntity.ok(postRepository.save(postToSave));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

}
