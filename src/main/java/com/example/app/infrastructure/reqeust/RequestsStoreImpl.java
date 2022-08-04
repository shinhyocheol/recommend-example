package com.example.app.infrastructure.reqeust;

import com.example.app.common.exception.EntityNotFoundException;
import com.example.app.domain.request.Requests;
import com.example.app.domain.request.RequestsStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class RequestsStoreImpl implements RequestsStore {
    private final RequestsRepository requestsRepository;

    @Override
    @Transactional
    public void store(Requests requests) {
        requestsRepository.save(requests);
    }

    @Override
    @Transactional
    public void delete(Integer seq) {
        Requests request = requestsRepository.findById(seq).orElseThrow(EntityNotFoundException::new);
        request.deleteRequestBySeq();
    }
}
