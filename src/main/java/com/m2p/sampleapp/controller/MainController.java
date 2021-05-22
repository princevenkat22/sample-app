package com.m2p.sampleapp.controller;

import com.m2p.sampleapp.dto.RequestDto;
import com.m2p.sampleapp.dto.ResponseDto;
import com.m2p.sampleapp.service.MainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class MainController {
    @Autowired
    MainService service;

    @PostMapping("/process")
    public ResponseDto processInfo(@Valid @RequestBody RequestDto request) {
        log.info("Received Request with payload - {}", request.toString());
        return service.processInfo(request);
    }

}
