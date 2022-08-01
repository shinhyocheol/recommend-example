package com.example.app.application;

import com.example.app.domain.RecommendRequestInfo;
import com.example.app.domain.RecommendRequestsService;
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
}
