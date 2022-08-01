package com.example.app.infrastructure.reqeust;

import com.example.app.domain.request.RecommendRequestInfo;
import com.example.app.domain.request.RecommendRequestsReader;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RecommendRequestsReaderImpl implements RecommendRequestsReader {
    private final RecommendRequestsRepository recommendRequestsRepository;

    @Override
    public List<RecommendRequestInfo> getRecommendRequestList() {
        return recommendRequestsRepository.findAll().stream()
                .map(item -> RecommendRequestInfo.of(item))
                .collect(Collectors.toList());
    }
}
