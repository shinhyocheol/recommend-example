package com.example.app.infrastructure.reqeust;

import com.example.app.domain.request.RecommendRequests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendRequestsRepository extends JpaRepository<RecommendRequests, Integer> {

}
