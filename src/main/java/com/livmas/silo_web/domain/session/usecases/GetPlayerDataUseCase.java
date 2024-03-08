package com.livmas.silo_web.domain.session.usecases;

import com.livmas.silo_web.domain.models.PlayerModel;
import org.springframework.stereotype.Component;

@Component
public class GetPlayerDataUseCase {
    public PlayerModel execute(int room_id, int player_id) {
        return new GetRandomPlayerModelUseCase().execute();
    }
}
