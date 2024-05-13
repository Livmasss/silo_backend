package com.livmas.silo_web.data.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity()
@Table(name = "bunkers")
@NoArgsConstructor
public class BunkerEntity extends BaseEntity{

    public BunkerEntity(
            String name,
            float frequency
    ) {
        super(name, frequency);
    }
}
