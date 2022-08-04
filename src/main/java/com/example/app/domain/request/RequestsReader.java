package com.example.app.domain.request;

import java.util.List;

public interface RequestsReader {

    List<RequestDetail> getRequestList();

    RequestDetail getRequestById(Integer seq);
}
