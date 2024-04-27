package com.livmas.silo_web.data.repositories;

import com.livmas.silo_web.data.entities.InformationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformationRepository extends JpaRepository<InformationEntity, Long> {
}
