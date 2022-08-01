package com.example.app.infrastructure.reqeust;

import com.example.app.domain.request.Requests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestsRepository extends JpaRepository<Requests, Integer> {

}
