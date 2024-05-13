package com.livmas.silo_web.domain.usecases.gameinfo;

import com.livmas.silo_web.data.services.CatastropheService;
import com.livmas.silo_web.dtos.CatastropheDto;
import com.livmas.silo_web.mappers.GameInfoMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class GetRandomCatastropheDtoUseCase {
    private final CatastropheService catastropheService;

    public CatastropheDto execute() {
        return GameInfoMapper.catastropheDataToDto(catastropheService.getEntity());
    }
}
