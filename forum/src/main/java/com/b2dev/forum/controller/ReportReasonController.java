package com.b2dev.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import com.b2dev.forum.entity.ReportReason;
import com.b2dev.forum.repository.ReportReasonRepository;


@RestController
@RequestMapping("reportReason")
public class ReportReasonController {

    @Autowired
    private ReportReasonRepository reportReasonRepository;

    @GetMapping
    public Page<ReportReason> getReportReasons(Pageable pageable) {
        return reportReasonRepository.findAll(pageable);
    }
}