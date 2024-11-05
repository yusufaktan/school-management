package com.aktanyusuf.service.impl;

import com.aktanyusuf.dto.DtoBaseProfile;
import com.aktanyusuf.dto.DtoBaseProfileIU;
import com.aktanyusuf.model.BaseProfile;
import com.aktanyusuf.repository.BaseProfileRepository;
import com.aktanyusuf.service.IBaseProfileService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BaseProfileService implements IBaseProfileService {

    @Autowired
    BaseProfileRepository baseProfileRepository;

    @Override
    public List<DtoBaseProfile> add(DtoBaseProfileIU dto) {
        BaseProfile baseProfile = new BaseProfile();
        BeanUtils.copyProperties(dto, baseProfile);
        baseProfileRepository.save(baseProfile);
        return getAll();
    }

    @Override
    public List<DtoBaseProfile> getAll() {
        List<BaseProfile> baseProfiles = baseProfileRepository.findAll();
        List<DtoBaseProfile> dtoBaseProfiles = new ArrayList<>();
        for (BaseProfile baseProfile : baseProfiles){
            DtoBaseProfile dtoBaseProfile = new DtoBaseProfile();
            BeanUtils.copyProperties(baseProfile, dtoBaseProfile);
            dtoBaseProfiles.add(dtoBaseProfile);
        }
        return dtoBaseProfiles;
    }

    @Override
    public DtoBaseProfile update(UUID id, DtoBaseProfileIU object) {
        for (BaseProfile baseProfile : baseProfileRepository.findAll()){
            if (baseProfile.getId().equals(id)){
                BeanUtils.copyProperties(object, baseProfile);
                baseProfileRepository.save(baseProfile);
                DtoBaseProfile dtoBaseProfile = new DtoBaseProfile();
                BeanUtils.copyProperties(baseProfile, dtoBaseProfile);
                return dtoBaseProfile;
            }
        }
        return null;
    }

    @Override
    public List<DtoBaseProfile> delete(UUID id) {
        List<BaseProfile> baseProfiles = baseProfileRepository.findAll();
        for (BaseProfile baseProfile : baseProfiles){
            if (id.equals(baseProfile.getId())){
                baseProfileRepository.delete(baseProfile);
                return getAll();
            }
        }
        return null;
    }

    @Override
    public DtoBaseProfile getById(UUID id) {
        List<BaseProfile> baseProfiles = baseProfileRepository.findAll();
        for (BaseProfile baseProfile : baseProfiles){
            if (id.equals(baseProfile.getId())){
                DtoBaseProfile dtoBaseProfile = new DtoBaseProfile();
                BeanUtils.copyProperties(baseProfile, dtoBaseProfile);
                return dtoBaseProfile;

            }
        }
        return null;
    }
}
