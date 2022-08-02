package com.example.app.domain.actions;

import com.example.app.enums.FeedbackActionType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "recommend_room_feedback_actions")
public class Actions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;

    @Enumerated(value = EnumType.STRING)
    @Column(length = 30, nullable = false)
    private FeedbackActionType actionType;

    @Comment(value = "신청 회원 번호")
    @Column(nullable = false)
    private Integer usersIdx;

}
