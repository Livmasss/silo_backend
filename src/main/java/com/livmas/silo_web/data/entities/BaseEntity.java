package com.livmas.silo_web.data.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "real default 0.5")
    private float frequency = 0.5f;

    protected BaseEntity(
            String name,
            float frequency
    ) {
        this.name = name;
        this.frequency = frequency;
    }
}
