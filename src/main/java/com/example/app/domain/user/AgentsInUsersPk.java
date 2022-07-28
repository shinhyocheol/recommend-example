package com.example.app.domain.user;

import java.io.Serializable;

/**
 * AgentsInUsers Entity의 복합키를 위해 생성
 */
public class AgentsInUsersPk implements Serializable {
    private Users user;
    private Agent agent;
}
