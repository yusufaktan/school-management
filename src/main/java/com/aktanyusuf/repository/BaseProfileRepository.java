package com.aktanyusuf.repository;

import com.aktanyusuf.model.BaseProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BaseProfileRepository extends JpaRepository<BaseProfile, UUID> {
}
