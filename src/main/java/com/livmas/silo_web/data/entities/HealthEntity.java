package com.livmas.silo_web.data.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "healths")
@NoArgsConstructor
public class HealthEntity extends PropertyEntity {
    public HealthEntity(
            String name,
            float frequency
    ) {
        super(name, frequency);
    }
}
