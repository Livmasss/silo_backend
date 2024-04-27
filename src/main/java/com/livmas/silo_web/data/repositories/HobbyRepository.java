package com.livmas.silo_web.data.repositories;

import com.livmas.silo_web.data.entities.HobbyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HobbyRepository extends JpaRepository<HobbyEntity, Long> {
}
