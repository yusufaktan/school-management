package com.aktanyusuf.controller.impl;

import com.aktanyusuf.controller.IBaseController;
import com.aktanyusuf.controller.IBaseProfileController;
import com.aktanyusuf.dto.DtoBaseProfile;
import com.aktanyusuf.dto.DtoBaseProfileIU;
import com.aktanyusuf.service.impl.BaseProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/base-profile")
public class BaseProfileController implements IBaseProfileController {

    @Autowired
    BaseProfileService baseProfileService;

    @Override
    public List<DtoBaseProfile> add(DtoBaseProfileIU dto) {
        return List.of();
    }

    @GetMapping
    @Override
    public List<DtoBaseProfile> getAll() {
        return baseProfileService.getAll();
    }

    @Override
    public DtoBaseProfile update(UUID id, DtoBaseProfileIU object) {
        return null;
    }

    @Override
    public List<DtoBaseProfile> delete(UUID id) {
        return List.of();
    }

    @Override
    public DtoBaseProfile getById(UUID id) {
        return null;
    }
}
