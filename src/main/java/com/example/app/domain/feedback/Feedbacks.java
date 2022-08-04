package com.example.app.domain.feedback;

import com.example.app.domain.BaseTimeEntity;
import com.example.app.domain.room.Rooms;
import com.example.app.enums.FeedbackType;
import com.example.app.enums.FeedbackUnFavoriteType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "recommend_room_feedbacks")
public class Feedbacks extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;

    @Comment(value = "피드백 타입")
    @Enumerated(value = EnumType.STRING)
    private FeedbackType feedbackType;

    @Comment(value = "사용자 피드백 메모")
    @Column(columnDefinition = "TEXT")
    private String memo;

    @Comment(value = "싫어요 타입인 경우 카테고리")
    @Column(length = 30)
    @Enumerated(value = EnumType.STRING)
    private FeedbackUnFavoriteType unfavoriteReasonType;

    @Comment(value = "추천매물 번호")
    @ManyToOne
    @JoinColumn(
            name = "recommend_rooms_seq",
            foreignKey = @ForeignKey(name = "fk_recommend_feedbacks_rooms_seq")
    )
    private Rooms recommendRoom;

    @Builder
    public Feedbacks(FeedbackType feedbackType, String memo, Rooms recommendRoom) {
        this.feedbackType = feedbackType;
        this.memo = memo;
        this.recommendRoom = recommendRoom;
    }
}
