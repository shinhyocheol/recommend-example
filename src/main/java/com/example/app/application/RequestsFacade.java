package com.example.app.application;

import com.example.app.domain.request.RequestCommand.RegisterRequest;
import com.example.app.domain.request.RequestInfo;
import com.example.app.domain.request.RequestsService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RequestsFacade {
    private final RequestsService requestsService;

    public List<RequestInfo> getRequestList() {
        return requestsService.getRequestList();
    }

    public void addRequest(RegisterRequest command) {
        requestsService.addRequest(command);
    }
}
