package com.livmas.silo_web.data.repositories;

import com.livmas.silo_web.data.entities.CatastropheEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatastropheRepository extends JpaRepository<CatastropheEntity, String> {
}
