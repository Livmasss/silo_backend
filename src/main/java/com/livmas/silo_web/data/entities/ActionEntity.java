package com.livmas.silo_web.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "actions")
@NoArgsConstructor
public class ActionEntity extends PropertyEntity {
    public ActionEntity(
            String name,
            float frequency
    ) {
        super(name, frequency);
    }
}
