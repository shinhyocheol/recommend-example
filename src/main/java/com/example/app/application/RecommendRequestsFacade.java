package com.example.app.application;

import com.example.app.domain.request.RecommendRequestCommand;
import com.example.app.domain.request.RecommendRequestCommand.RegisterRecommendRequest;
import com.example.app.domain.request.RecommendRequestInfo;
import com.example.app.domain.request.RecommendRequestsService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RecommendRequestsFacade {
    private final RecommendRequestsService recommendRequestsService;

    public List<RecommendRequestInfo> getRecommendRequestList() {
        return recommendRequestsService.getRecommendRequestList();
    }

    public void addRecommendRequest(RegisterRecommendRequest command) {
        recommendRequestsService.addRecommendRequest(command);
    }
}
