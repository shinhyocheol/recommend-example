package com.example.app.application;

import com.example.app.domain.recommend.RecommendRequestInfo;
import com.example.app.domain.recommend.RecommendRequestsService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RecommendRequestsFacade {
    private final RecommendRequestsService recommendRequestsService;

    public List<RecommendRequestInfo> recommendRequestList() {
        return recommendRequestsService.recommendRequestList();
    }
}
