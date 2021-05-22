package com.m2p.sampleapp.mapper;

import com.m2p.sampleapp.dto.RequestDto;
import com.m2p.sampleapp.model.Request;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Lazy;

@Lazy
@Mapper
public interface RequestMapper {
    Request requestDtoToModel(RequestDto requestDto);
}
