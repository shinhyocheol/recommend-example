package com.example.app.domain.request;

import com.example.app.domain.request.RequestsCommand.RegisterRequest;
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
    public List<RequestDetail> getRequestList() {
        List<RequestDetail> result = requestsReader.getRequestList();
        return result;
    }

    @Override
    @Transactional
    public void addRequest(RegisterRequest command) {
        requestsStore.store(command.toEntity());
    }

    @Override
    public RequestDetail getRequestBySeq(Integer seq) {
        return requestsReader.getRequestById(seq);
    }

    @Override
    public void deleteRequestById(Integer seq) {
        requestsStore.delete(seq);
    }
}
