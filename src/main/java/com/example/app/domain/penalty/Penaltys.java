package com.example.app.domain.penalty;

import com.example.app.domain.BaseTimeEntity;
import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "recommend_room_feedback_agent_penaltys")
public class Penaltys extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;

    @Comment(value = "대상 중개소 아이디")
    @Column(length = 50, nullable = false)
    private String agentId;

    @Comment(value = "패널티 활성화 여부")
    private Boolean isDisable;

    @Comment(value = "추천매물 이용제한 시작일시")
    @Column(nullable = false, columnDefinition = "timestamp with time zone")
    private ZonedDateTime periodFrom;

    @Comment(value = "추천매물 이용제한 종료일시")
    @Column(nullable = false, columnDefinition = "timestamp with time zone")
    private ZonedDateTime periodTo;
}
