package com.example.app.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Getter
@Entity
@NoArgsConstructor
@Table(
        name = "users",
        uniqueConstraints = @UniqueConstraint(
                name = "users_idx_ukey",
                columnNames = "idx"
        )
)
public class Users {
    @Comment(value = "계정 이메일")
    @Id
    private String id;

    @Comment("통합 사용자 순번")
    @Column(nullable = false, columnDefinition = "bigint default nextval('users_idx_seq'::regclass)")
    private Long idx;

    @Comment(value = "비밀번호")
    @Column(columnDefinition = "text")
    private String password;

    @Comment(value = "이름")
    @Column(length = 100)
    private String name;

    @Comment(value = "휴대폰 번호")
    @Column(length = 50)
    private String phone;

    @Comment(value = "연락받기 휴대폰 번호")
    @Column(length = 50)
    private String inqueryPhone;

    @Comment(value = "전화번호")
    @Column(length = 50)
    private String tel;

    @Column(nullable = false, columnDefinition = "boolean default false")
    private Boolean isSafeAuth;
}
