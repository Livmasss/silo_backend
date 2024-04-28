package com.livmas.silo_web.data.services;


import java.util.List;
import java.util.Optional;

public interface BaseService <T> {
    T getEntity();
    List<T> getEntities(int rowsCount);
    Optional<T> getById(Long id);
}
