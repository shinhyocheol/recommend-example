package com.example.app.domain.request;

import com.example.app.domain.request.RecommendRequestCommand.RegisterRecommendRequest;
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
        List<RecommendRequestInfo> result = recommendRequestsReader.getRecommendRequestList();
        return result;
    }

    @Override
    @Transactional
    public void addRecommendRequest(RegisterRecommendRequest command) {
        RecommendRequests recommendRequests = command.toEntity();
        recommendRequestsStore.store(recommendRequests);
    }
}
