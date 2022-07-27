package com.example.app.domain.room.simple;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "simple_rooms")
public class SimpleRooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;
}
