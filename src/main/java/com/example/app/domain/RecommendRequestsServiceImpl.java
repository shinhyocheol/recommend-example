package com.example.app.domain;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RecommendRequestsServiceImpl implements RecommendRequestsService {
    private final RecommendRequestsReader recommendRequestsReader;
    private final RecommendRequestsStore recommendRequestsStore;

    @Override
    @Transactional(readOnly = true)
    public List<RecommendRequestInfo> getRecommendRequestList() {
        return recommendRequestsReader.getRecommendRequestList();
    }
}
