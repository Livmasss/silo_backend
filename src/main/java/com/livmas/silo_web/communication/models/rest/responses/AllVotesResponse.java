package com.livmas.silo_web.communication.models.rest.responses;

import java.util.List;

public class AllVotesResponse {
    public List<PlayerVotesResponse> items;

    public AllVotesResponse(List<PlayerVotesResponse> items) {
        this.items = items;
    }
}
