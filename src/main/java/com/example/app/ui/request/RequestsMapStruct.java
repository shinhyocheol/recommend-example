package com.example.app.ui.request;

import com.example.app.configuration.mapstruct.MapStructConfig;
import com.example.app.domain.request.RequestsCommand;
import org.mapstruct.Mapper;

@Mapper(config = MapStructConfig.class)
public interface RequestsMapStruct {
    RequestsCommand.RegisterRequest of(RequestsDto.AddParam param);
}
