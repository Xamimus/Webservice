package com.b2dev.forum.repository;

import java.util.*;

import com.b2dev.forum.entity.ReportReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.b2dev.forum.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

  Post getById(Long id);

  }
