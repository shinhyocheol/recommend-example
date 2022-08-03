package com.example.app.domain.request;

import com.example.app.domain.request.RequestCommand.RegisterRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RequestsServiceImpl implements RequestsService {
    private final RequestsReader requestsReader;
    private final RequestsStore requestsStore;

    @Override
    @Transactional(readOnly = true)
    public List<RequestInfo> getRequestList() {
        List<RequestInfo> result = requestsReader.getRequestList();
        return result;
    }

    @Override
    @Transactional
    public void addRequest(RegisterRequest command) {
        Requests requests = command.toEntity();
        requestsStore.store(requests);
    }
}
