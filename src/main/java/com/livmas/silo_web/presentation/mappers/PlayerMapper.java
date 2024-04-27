package com.livmas.silo_web.presentation.mappers;

import com.livmas.silo_web.domain.models.OpenedPlayerModel;
import com.livmas.silo_web.domain.models.PlayerModel;
import com.livmas.silo_web.domain.models.enums.PlayerPropertyName;
import com.livmas.silo_web.presentation.models.rest.responses.OpenedPlayerResponse;

public abstract class PlayerMapper {

    public static OpenedPlayerResponse openedResponseFromOpenedModel(OpenedPlayerModel model) {
        return new OpenedPlayerResponse (
                model.getId(),
                model.getName(),
                model.getGender(),
                model.getHealth(),
                model.getPersonality(),
                model.getProfession(),
                model.getHobby(),
                model.getPhobia(),
                model.getInventory(),
                model.getInformation(),
                model.getAction()
        );
    }

    public static OpenedPlayerModel openedResponseFromModel(PlayerModel playerModel) {
        return new OpenedPlayerModel(
                playerModel.getId(),
                playerModel.getName(),
                playerModel.getOpenedContent(PlayerPropertyName.GENDER),
                playerModel.getOpenedContent(PlayerPropertyName.HEALTH),
                playerModel.getOpenedContent(PlayerPropertyName.PERSONALITY),
                playerModel.getOpenedContent(PlayerPropertyName.PROFESSION),
                playerModel.getOpenedContent(PlayerPropertyName.HOBBY),
                playerModel.getOpenedContent(PlayerPropertyName.PHOBIA),
                playerModel.getOpenedContent(PlayerPropertyName.INVENTORY),
                playerModel.getOpenedContent(PlayerPropertyName.INFORMATION),
                playerModel.getOpenedContent(PlayerPropertyName.ACTION)
        );
    }
}
