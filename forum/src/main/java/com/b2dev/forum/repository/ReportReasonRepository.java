package com.b2dev.forum.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.b2dev.forum.entity.Post;
import com.b2dev.forum.entity.Report;
import com.b2dev.forum.entity.ReportReason;

@Repository
public interface ReportReasonRepository extends JpaRepository<ReportReason, Integer> {

  ReportReason getById(Long id);

}
