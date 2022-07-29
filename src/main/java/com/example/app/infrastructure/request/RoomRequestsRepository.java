package com.example.app.infrastructure.request;

import com.example.app.domain.recommend.request.RoomRequests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRequestsRepository extends JpaRepository<RoomRequests, Integer> {

}
