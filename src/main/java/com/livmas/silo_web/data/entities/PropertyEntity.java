package com.livmas.silo_web.data.entities;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class PropertyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(columnDefinition = "real default 0.5")
    private float frequency = 0.5f;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public Long getId() {
        return id;
    }

    public float getFrequency() {
        return frequency;
    }
    public void setFrequency(float frequency) {
        this.frequency = frequency;
    }
}
