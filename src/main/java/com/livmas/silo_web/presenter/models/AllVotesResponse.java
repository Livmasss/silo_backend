package com.livmas.silo_web.presenter.models;

import java.util.List;

public class AllVotesResponse {
    public List<PlayerVotesResponse> items;

    public AllVotesResponse(List<PlayerVotesResponse> items) {
        this.items = items;
    }
}
