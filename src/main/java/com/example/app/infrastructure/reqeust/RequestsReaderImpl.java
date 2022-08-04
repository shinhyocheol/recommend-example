package com.example.app.infrastructure.reqeust;

import com.example.app.common.exception.EntityNotFoundException;
import com.example.app.domain.request.RequestDetail;
import com.example.app.domain.request.Requests;
import com.example.app.domain.request.RequestsReader;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RequestsReaderImpl implements RequestsReader {
    private final RequestsRepository requestsRepository;

    @Override
    public List<RequestDetail> getRequestList() {
        return requestsRepository.findAll().stream()
                .map(item -> RequestDetail.of(item))
                .collect(Collectors.toList());
    }

    @Override
    public RequestDetail getRequestById(Integer seq) {
        Requests request = requestsRepository.findById(seq).orElseThrow(EntityNotFoundException::new);
        return RequestDetail.of(request);
    }
}
