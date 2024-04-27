package com.livmas.silo_web.presentation.models.rest.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class AllPlayersResponse {
    private final List<OpenedPlayerResponse> players;
}