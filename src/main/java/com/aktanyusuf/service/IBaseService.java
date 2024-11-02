package com.aktanyusuf.service;

import java.util.List;

public interface IBaseService<T, UUID, IU> {

    List<T> add(IU dto);

    List<T> getAll();

    T update(UUID id, T object);

    List<T> delete(UUID id);

    T getById(UUID id);
}
