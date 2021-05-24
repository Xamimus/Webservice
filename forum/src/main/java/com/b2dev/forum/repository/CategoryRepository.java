package com.b2dev.forum.repository;

import java.util.*;

import com.b2dev.forum.entity.ReportReason;
import com.github.javafaker.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.b2dev.forum.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category getById(Long id);

    public Category getByName (String name);

  }
