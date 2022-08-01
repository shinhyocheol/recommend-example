package com.example.app.configuration.properties;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

@Getter
@AllArgsConstructor
@Validated
@ConstructorBinding
@ConfigurationProperties(prefix = "app.config.datasource.dabang.hikari", ignoreUnknownFields = false)
public class DabangDatabaseProperties {
    @NotBlank(message = "다방 데이터베이스 드라이버 클래스명을 설정해주세요.")
    private final String driverClassName;

    @NotBlank(message = "다방 데이터베이스 주소를 설정해주세요.")
    private final String jdbcUrl;

    @NotBlank(message = "다방 데이터베이스 사용자명을 설정해주세요.")
    private final String username;

    @NotBlank(message = "다방 데이터베이스 비밀번호를 설정해주세요.")
    private final String password;

    @Min(value = 1, message = "다방 데이터베이스 커넥션 풀 개수는 최소 {value} 보다 크게 설정해주세요. ")
    private final int poolSize;
}
