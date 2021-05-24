package com.b2dev.forum.repository;

import com.b2dev.forum.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.b2dev.forum.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  User getById(Long id);

  Optional<User> findByEmail(String email);

  Boolean existsByEmail(String email);

  }
