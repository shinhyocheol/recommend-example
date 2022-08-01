package com.example.app.infrastructure.reqeust;

import com.example.app.domain.request.RecommendRequests;
import com.example.app.domain.request.RecommendRequestsStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RecommendRequestsStoreImpl implements RecommendRequestsStore {
    private final RecommendRequestsRepository recommendRequestsRepository;

    @Override
    public void store(RecommendRequests recommendRequests) {
        recommendRequestsRepository.save(recommendRequests);
    }
}
