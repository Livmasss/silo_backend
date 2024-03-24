package com.livmas.silo_web.data.daos;

import java.util.UUID;

public interface BaseDao<T> {
    void createItem(T item);
    T readItem(UUID id);
    void updateItem(T item);
    void deleteItem(T item);
}
