package com.m2p.sampleapp;

import com.m2p.sampleapp.dto.RequestDto;
import com.m2p.sampleapp.dto.ResponseDto;
import com.m2p.sampleapp.repository.CalcRepository;
import com.m2p.sampleapp.repository.CalcRepositoryImpl;
import com.m2p.sampleapp.service.MainService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.PostConstruct;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class SampleAppApplicationTests {
    @Autowired
    MainService service;

    @Qualifier("CalcRepositoryImpl")
    @Autowired
    CalcRepository calcRepository;

    private RequestDto requestDto;

    @PostConstruct
    void init() {
        requestDto = new RequestDto(5, 10, '+');
    }

    @DisplayName("Calc Response")
    @Test
    @Order(1)
    void testAdd() {
        ResponseDto responseDto = service.processInfo(requestDto);
        assertEquals(15, responseDto.getResult());
    }

    @DisplayName("Calc Response H2")
    @Test
    @Order(2)
    void testH2Response() {

        Double result = calcRepository.calcResult(5.0, '-', 3.0);
        assertEquals(2.0, result);
    }

}
