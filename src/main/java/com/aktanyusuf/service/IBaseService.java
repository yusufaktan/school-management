package com.aktanyusuf.service;

import java.util.UUID;

public interface IBaseService {

    public <T> T add(T object);

    public <T> T getAll();

    public <T> T update(UUID id, T object);

    public <T> T delete(UUID id, T object);

    public <T> T getById(UUID id);

}
