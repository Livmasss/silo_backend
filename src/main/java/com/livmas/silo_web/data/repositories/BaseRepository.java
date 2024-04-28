package com.livmas.silo_web.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.util.List;

@NoRepositoryBean
public interface BaseRepository<T> extends JpaRepository<T, Long> {
    @Query(value = "SELECT p FROM #{#entityName} p ORDER BY random() LIMIT 1")
    List<T> getRandom(
            @Param("count") int entitiesCount
    );
}
