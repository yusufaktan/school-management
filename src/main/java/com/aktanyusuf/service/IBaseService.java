package com.aktanyusuf.service;

import java.util.List;
import java.util.UUID;

public interface IBaseService<T> {

    List<T> add(T object);

    List<T> getAll();

    T update(UUID id, T object);

    List<T> delete(UUID id);

    T getById(UUID id);
}
