package com.b2dev.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.b2dev.forum.entity.Role;
import com.b2dev.forum.repository.RoleRepository;


@RestController
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;
}