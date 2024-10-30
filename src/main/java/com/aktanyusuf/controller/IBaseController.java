package com.aktanyusuf.controller;

import java.util.List;
import java.util.UUID;

public interface IBaseController<T> {

    List<T> add(T object);

    List<T> getAll();

    T update(UUID id, T object);

    List<T> delete(UUID id);

    T getById(UUID id);
}
