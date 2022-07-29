package com.example.app.infrastructure;

import com.example.app.domain.recommend.RecommendRequests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendRequestsRepository extends JpaRepository<RecommendRequests, Integer> {

}
