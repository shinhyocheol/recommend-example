package com.example.app.domain.user;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "agents_in_users")
@IdClass(AgentsInUsersPk.class)
public class AgentsInUsers implements Serializable {

    @Id
    @Comment(value = "사용자 아이디")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "user_id",
            columnDefinition = "varchar(300) not null",
            foreignKey = @ForeignKey(name = "fk_agents_in_users_user_id"))
    private Users user;

    @Id
    @Comment(value = "에이전트(중개소) 아이디")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "agent_id",
            columnDefinition = "varchar(50) not null",
            foreignKey = @ForeignKey(name = "fk_agents_in_users_agent_id"))
    private Agent agent;

    @Column(columnDefinition = "boolean default false")
    private Boolean isPrimary;
}
