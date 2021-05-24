package com.b2dev.forum.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.b2dev.forum.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {


  }