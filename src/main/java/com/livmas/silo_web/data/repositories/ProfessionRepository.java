package com.livmas.silo_web.data.repositories;

import com.livmas.silo_web.data.entities.ProfessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionRepository extends JpaRepository<ProfessionEntity, Long> {
}
