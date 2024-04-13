package com.livmas.silo_web.domain.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerProperty {
    String content;
    boolean isOpened;

    public PlayerProperty(
            String content,
            boolean isOpened
    ) {
        this.content = content;
        this.isOpened = isOpened;
    }
}
