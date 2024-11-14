package com.aktanyusuf.service.impl;

import com.aktanyusuf.service.IDepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DepartmentService implements IDepartmentService {

    @Override
    public List add(Object dto) {
        return List.of();
    }

    @Override
    public List getAll() {
        return List.of();
    }

    @Override
    public Object update(Object id, Object object) {
        return null;
    }

    @Override
    public List delete(Object id) {
        return List.of();
    }

    @Override
    public Object getById(Object id) {
        return null;
    }
}
