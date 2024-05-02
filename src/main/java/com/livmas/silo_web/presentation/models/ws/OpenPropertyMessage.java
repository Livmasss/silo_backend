package com.livmas.silo_web.presentation.models.ws;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.livmas.silo_web.domain.models.enums.PlayerPropertyName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class OpenPropertyMessage {
    private PlayerPropertyName property;
    @JsonProperty("player_id")
    private int playerId;
}
