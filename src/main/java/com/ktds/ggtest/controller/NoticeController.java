package com.ktds.ggtest.controller;

import com.ktds.ggtest.dto.NoticeRequest;
import com.ktds.ggtest.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @PostMapping("/notice")
    public ResponseEntity<Void> createNotice(@RequestBody NoticeRequest request){
        noticeService.createNotice(request.getId(),
                request.getTitle(),
                request.getContent(),
                request.getAuthor(),
                request.getCreateDate());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
