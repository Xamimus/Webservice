package com.b2dev.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.b2dev.forum.entity.Post;
import com.b2dev.forum.repository.PostRepository;


@RestController
public class PostController {

    @Autowired
    private PostRepository postRepository;
}