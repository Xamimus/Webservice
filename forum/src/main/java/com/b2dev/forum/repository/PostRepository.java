package com.b2dev.forum.repository;


import java.util.*;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.b2dev.forum.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

  Post getById(long id);

  Post findById(long id);

  List<Post> findByTopicIdOrderByCreatedAtDesc(long id, Pageable pageable);

  }
