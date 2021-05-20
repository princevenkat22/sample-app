package com.m2p.sampleapp.service;

import com.m2p.sampleapp.dto.RequestDto;
import com.m2p.sampleapp.dto.ResponseDto;
import com.m2p.sampleapp.mapper.RequestMapper;
import com.m2p.sampleapp.model.Request;
import com.m2p.sampleapp.repository.MainRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Request result = persist(request);
        return new ResponseDto(request.getId(), result.getOutput(), result.getAson());
    }

    private Request persist(Request request) {
        repository.save(request);
        return request;
    }
}
