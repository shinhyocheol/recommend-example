package com.example.app.infrastructure.reqeust;

import com.example.app.domain.request.Requests;
import com.example.app.domain.request.RequestsStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RequestsStoreImpl implements RequestsStore {
    private final RequestsRepository requestsRepository;

    @Override
    public void store(Requests requests) {
        requestsRepository.save(requests);
    }
}
