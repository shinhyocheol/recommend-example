package com.example.app.domain.request;

import com.example.app.domain.request.RequestsCommand.RegisterRequest;
import java.util.List;

public interface RequestsService {

    List<RequestDetail> getRequestList();

    void addRequest(RegisterRequest command);

    RequestDetail getRequestBySeq(Integer seq);

    void deleteRequestById(Integer seq);
}
