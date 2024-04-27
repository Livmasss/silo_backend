package com.livmas.silo_web.data.repositories;

import com.livmas.silo_web.data.entities.HealthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthRepository extends JpaRepository<HealthEntity, Long> {
}
