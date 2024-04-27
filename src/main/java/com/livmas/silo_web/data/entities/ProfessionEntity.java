package com.livmas.silo_web.data.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "professions")
@NoArgsConstructor
public class ProfessionEntity extends PropertyEntity{
    public ProfessionEntity(
            String name,
            float frequency
    ) {
        super(name, frequency);
    }
}
