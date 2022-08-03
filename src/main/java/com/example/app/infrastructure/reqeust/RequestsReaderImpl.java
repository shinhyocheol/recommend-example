package com.example.app.infrastructure.reqeust;

//import com.example.app.domain.request.RequestInfo;
import com.example.app.domain.request.RequestsReader;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RequestsReaderImpl implements RequestsReader {
    private final RequestsRepository requestsRepository;

//    @Override
//    public List<RequestInfo> getRequestList() {
//        return requestsRepository.findAll().stream()
//                .map(item -> RequestInfo.of(item))
//                .collect(Collectors.toList());
//    }
}
