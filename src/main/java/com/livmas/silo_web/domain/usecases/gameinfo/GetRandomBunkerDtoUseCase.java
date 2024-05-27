package com.livmas.silo_web.domain.usecases.gameinfo;

import com.livmas.silo_web.data.services.BunkerService;
import com.livmas.silo_web.dtos.BunkerDTO;
import com.livmas.silo_web.mappers.GameInfoMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class GetRandomBunkerDtoUseCase {
    private final BunkerService bunkerService;

    public BunkerDTO execute() {
        return GameInfoMapper.bunkerDataToDto(bunkerService.getEntity());
    }
}
