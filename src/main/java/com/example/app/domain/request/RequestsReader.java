package com.example.app.domain.request;

import java.util.List;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public interface RequestsReader {

    List<RequestInfo> getRequestList();

    RequestInfo getRequestById(Integer seq);
}
