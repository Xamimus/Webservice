package com.b2dev.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.b2dev.forum.entity.Post;
import com.b2dev.forum.entity.Report;
import com.b2dev.forum.entity.ReportReason;
import com.b2dev.forum.repository.PostRepository;
import com.b2dev.forum.repository.ReportReasonRepository;
import com.b2dev.forum.repository.ReportRepository;
import com.b2dev.forum.security.service.UserDetailsServiceImpl;


@RestController
@RequestMapping("report")
public class ReportController {

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private ReportReasonRepository reportReasonRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public Page<Report> getReports(Pageable pageable) {
        return reportRepository.findAll(pageable);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_MODERATOR')")
    @PostMapping
    public Report addReport(@RequestBody Report report) {
        Report reportToSave = new Report();
        reportToSave.setAuthor(UserDetailsServiceImpl.getCurrentUser());
        ReportReason reportReason = reportReasonRepository.getById(report.getPost().getId());
        reportToSave.setReason(reportReason);
        Post post = postRepository.getById(report.getPost().getId());
        reportToSave.setPost(post);
        reportToSave = reportRepository.save(reportToSave);
        return reportToSave;
    }
}