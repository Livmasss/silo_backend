package com.livmas.silo_web.presentation.controllers.gameinfo;

import com.livmas.silo_web.domain.usecases.gameinfo.GetBunkerInfoUseCase;
import com.livmas.silo_web.domain.usecases.gameinfo.GetCatastropheInfoUseCase;
import com.livmas.silo_web.presentation.mappers.GameInfoMapper;
import com.livmas.silo_web.presentation.models.rest.responses.BunkerInfoResponseModel;
import com.livmas.silo_web.presentation.models.rest.responses.CatastropheResponseModel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/api")
public class GameInfoRestController {
    GetBunkerInfoUseCase getBunkerInfoUseCase;
    GetCatastropheInfoUseCase getCatastropheInfoUseCase;

    @GetMapping("/bunker/{game_id}")
    BunkerInfoResponseModel getBunkerInfo(@PathVariable("game_id") UUID gameId) {
        try {
            return GameInfoMapper.bunkerResponseModelFromBunkerModel(getBunkerInfoUseCase.execute(gameId));
        }
        catch (Exception e) {
            return null;
        }
    }
    @GetMapping("/catastophe/{game_id}")
    CatastropheResponseModel getCatastrophe(@PathVariable("game_id") UUID gameId) {
        try {
            return GameInfoMapper.catastropheResponseModelFromCatastropheModel(getCatastropheInfoUseCase.execute(gameId));
        }
        catch (Exception e) {
            return null;
        }
    }
}
