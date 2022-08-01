package com.example.app.infrastructure;

import com.example.app.domain.RecommendRequestInfo;
import com.example.app.domain.RecommendRequestsReader;
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
