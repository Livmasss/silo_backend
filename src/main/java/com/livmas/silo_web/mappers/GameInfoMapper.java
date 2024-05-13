package com.livmas.silo_web.mappers;

import com.livmas.silo_web.data.entities.CatastropheEntity;
import com.livmas.silo_web.domain.models.BunkerModel;
import com.livmas.silo_web.domain.models.CatastropheModel;
import com.livmas.silo_web.dtos.BunkerDTO;
import com.livmas.silo_web.dtos.CatastropheDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public abstract class GameInfoMapper {
    public static BunkerModel bunkerDtoToDomain(BunkerDTO dto) {
        return new BunkerModel(
                dto.description(),
                dto.capacity()
        );
    }
    public static CatastropheModel catastropheDtoToDomain(CatastropheDto dto) {
        return new CatastropheModel(
                dto.title(),
                dto.description()
        );
    }

    public static CatastropheDto catastropheDataToDto(CatastropheEntity entity) {
        return new CatastropheDto(
                entity.getName(),
                entity.getDescription()
        );
    }
}
