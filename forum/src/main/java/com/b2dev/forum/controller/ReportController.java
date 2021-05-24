package com.b2dev.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.b2dev.forum.entity.Report;
import com.b2dev.forum.repository.ReportRepository;


@RestController
@RequestMapping("report")
public class ReportController {

    @Autowired
    private ReportRepository reportRepository;

    @GetMapping
    public Page<Report> getReports(Pageable pageable) {
        return reportRepository.findAll(pageable);
    }
}