package com.aktanyusuf.controller.impl;

import com.aktanyusuf.controller.IBaseController;
import com.aktanyusuf.controller.IBaseProfileController;
import com.aktanyusuf.dto.DtoBaseProfile;
import com.aktanyusuf.dto.DtoBaseProfileIU;
import com.aktanyusuf.service.impl.BaseProfileService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/base-profile")
public class BaseProfileController implements IBaseProfileController {

    @Autowired
    BaseProfileService baseProfileService;

    @PostMapping
    @Override
    public List<DtoBaseProfile> add(@RequestBody @Valid DtoBaseProfileIU dto) {
        return baseProfileService.add(dto);
    }

    @GetMapping
    @Override
    public List<DtoBaseProfile> getAll() {
        return baseProfileService.getAll();
    }

    @PutMapping(path = "/{id}")
    @Override
    public DtoBaseProfile update(@PathVariable(name = "id") UUID id, @RequestBody @Valid DtoBaseProfileIU object) {
        return baseProfileService.update(id, object);
    }

    @DeleteMapping(path = "/{id}")
    @Override
    public List<DtoBaseProfile> delete(@PathVariable(name = "id") UUID id) {
        return baseProfileService.delete(id);
    }

    @GetMapping(path = "/{id}")
    @Override
    public DtoBaseProfile getById(@PathVariable(name = "id") UUID id) {
        return baseProfileService.getById(id);
    }
}
