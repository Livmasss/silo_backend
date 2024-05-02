package com.livmas.silo_web.presentation.models.rest.responses;

import java.util.List;

public record AllVotesResponse(List<PlayerVotesResponse> items) {
}
