package com.example.app.domain.request;

public interface RequestsStore {
    void store(Requests recommendRequests);

    void delete(Integer seq);
}
