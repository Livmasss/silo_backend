package com.livmas.silo_web.data.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "catastrophes")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CatastropheEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    public CatastropheEntity(
            String name,
            String description,
            float frequency
    ) {
        super(name, frequency);
        this.description = description;
    }

    public CatastropheEntity(
            String name,
            String description
    ) {
        super(name, 0.5f);
        this.description = description;
    }
}
