package com.b2dev.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.b2dev.forum.entity.User;
import com.b2dev.forum.repository.UserRepository;


@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
}