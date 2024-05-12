package com.livmas.silo_web.presentation.mappers;

import com.livmas.silo_web.domain.models.BunkerModel;
import com.livmas.silo_web.domain.models.CatastropheModel;
import com.livmas.silo_web.presentation.models.rest.responses.BunkerInfoResponseModel;
import com.livmas.silo_web.presentation.models.rest.responses.CatastropheResponseModel;

public abstract class GameInfoMapper {
    private GameInfoMapper() {}
    public static BunkerInfoResponseModel bunkerResponseModelFromBunkerModel(BunkerModel model) {
        return new BunkerInfoResponseModel(
                model.description(),
                model.capacity()
        );
    }
    public static CatastropheResponseModel catastropheResponseModelFromCatastropheModel(CatastropheModel model) {
        return new CatastropheResponseModel(
                model.title(),
                model.description()
        );
    }
}
