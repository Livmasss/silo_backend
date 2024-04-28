package com.livmas.silo_web.domain.usecases.players;

import com.livmas.silo_web.data.services.AllPropertiesService;
import com.livmas.silo_web.domain.models.PlayerModel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class GetRandomPlayerModelUseCase {

    AllPropertiesService propertiesService;

    public PlayerModel execute() {
         return new PlayerModel(
                    10,
                    null,
                    List.of(
                            propertiesService.getGender().getName(),
                            propertiesService.getHealth().getName(),
                            propertiesService.getCharacter().getName(),
                            propertiesService.getProfession().getName(),
                            propertiesService.getHobby().getName(),
                            propertiesService.getPhobia().getName(),
                            propertiesService.getInventory().getName(),
                            propertiesService.getInformation().getName(),
                            propertiesService.getAction().getName()
                    )
            );
    }
}
