package com.example.app.domain.feedbackcount;

import com.example.app.domain.BaseTimeEntity;
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
@Table(name = "recommend_room_agent_feedback_counts")
public class AgentFeedbackCounts extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;

    @Comment(value = "중개소 아이디")
    @Column(length = 50, nullable = false)
    private String agentId;

    @Comment(value = "중개소 회원번호")
    @Column(nullable = false)
    private Integer usersIdx;

    @Comment(value = "피드백 '좋아요' 수 현황")
    private Integer favoriteCount;

    @Comment(value = "피드백 '싫어요' 수 현황")
    private Integer unfavoriteCount;
}
