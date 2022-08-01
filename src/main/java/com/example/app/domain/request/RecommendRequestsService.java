package com.example.app.domain.request;

import com.example.app.domain.request.RecommendRequestCommand.RegisterRecommendRequest;
import java.util.List;

public interface RecommendRequestsService {

    List<RecommendRequestInfo> getRecommendRequestList();

    void addRecommendRequest(RegisterRecommendRequest command);
}
