package com.example.app.interfaces.request;

import com.example.app.configuration.mapstruct.MapStructConfig;
import com.example.app.domain.request.RecommendRequestCommand;
import org.mapstruct.Mapper;

@Mapper(config = MapStructConfig.class)
public interface RecommendRequestMapStruct {
    RecommendRequestCommand.RegisterRecommendRequest of(RecommendRequestDto.AddParam param);
}
