package com.m2p.sampleapp.service;

import com.m2p.sampleapp.dto.RequestDto;
import com.m2p.sampleapp.dto.ResponseDto;

public interface MainService {
    ResponseDto processInfo(RequestDto request);
}
