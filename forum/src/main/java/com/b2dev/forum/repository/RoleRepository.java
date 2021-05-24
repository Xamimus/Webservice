package com.b2dev.forum.repository;

import java.util.*;

import com.b2dev.forum.entity.ReportReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.b2dev.forum.entity.EnumRole;
import com.b2dev.forum.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

  Role getById(Long id);

  Optional<Role> findByName(EnumRole name);
  }
