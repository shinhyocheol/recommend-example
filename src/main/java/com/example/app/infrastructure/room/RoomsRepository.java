package com.example.app.infrastructure.room;

import com.example.app.domain.room.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomsRepository extends JpaRepository<Rooms, Integer> {

}
