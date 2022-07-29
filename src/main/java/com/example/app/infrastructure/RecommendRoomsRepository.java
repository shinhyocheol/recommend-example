package com.example.app.infrastructure;

import com.example.app.domain.recommend.RecommendRooms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendRoomsRepository extends JpaRepository<RecommendRooms, Integer> {

}
