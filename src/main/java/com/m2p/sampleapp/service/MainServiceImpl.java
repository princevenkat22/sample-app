package com.m2p.sampleapp.service;

import com.m2p.sampleapp.dto.RequestDto;
import com.m2p.sampleapp.dto.ResponseDto;
import com.m2p.sampleapp.mapper.RequestMapper;
import com.m2p.sampleapp.model.Request;
import com.m2p.sampleapp.repository.MainRepository;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MainServiceImpl implements MainService {
    @Autowired
    MainRepository repository;

    @Override
    public ResponseDto processInfo(RequestDto requestDto) {

        RequestMapper mapper
                = Mappers.getMapper(RequestMapper.class);
        Request request = mapper.requestDtoToModel(requestDto);
        request.setOutput(repository.calcResult(request.getInp1(), request.getOperator(), request.getInp2()));
        log.info("Request processed with Output - {}", request.getOutput());
        Request result = persist(request);
        return new ResponseDto(request.getId(), result.getOutput(), result.getAson());
    }

    private Request persist(Request request) {
        repository.save(request);
        log.info("Request saved with id - {}", request.getId());
        return request;
    }
}
