package com.example.app.ui.request;

import com.example.app.configuration.mapstruct.MapStructConfig;
import com.example.app.domain.request.RequestCommand;
import org.mapstruct.Mapper;

@Mapper(config = MapStructConfig.class)
public interface RequestsMapStruct {
    RequestCommand.RegisterRequest of(RequestsDto.AddParam param);
}
