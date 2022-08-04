package com.example.app.domain.request;

import com.example.app.domain.request.RequestCommand.RegisterRequest;
import java.util.List;

public interface RequestsService {

    List<RequestInfo> getRequestList();

    void addRequest(RegisterRequest command);

    RequestInfo getRequestBySeq(Integer seq);

    void deleteRequestById(Integer seq);
}
