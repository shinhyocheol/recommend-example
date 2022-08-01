package com.example.app.infrastructure.room;

import com.example.app.domain.room.RecommendRooms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendRoomsRepository extends JpaRepository<RecommendRooms, Integer> {

}
