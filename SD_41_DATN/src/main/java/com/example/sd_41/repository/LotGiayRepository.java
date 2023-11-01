package com.example.sd_41.repository;

import com.example.sd_41.model.LotGiay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LotGiayRepository extends JpaRepository<LotGiay, UUID> {

}
