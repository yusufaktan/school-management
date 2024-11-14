package com.aktanyusuf.repository;

import com.aktanyusuf.model.BaseProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BaseProfileRepository extends JpaRepository<BaseProfile, UUID> {
}
