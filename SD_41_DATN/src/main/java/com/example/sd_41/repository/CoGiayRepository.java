package com.example.sd_41.repository;

import com.example.sd_41.model.CoGiay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CoGiayRepository extends JpaRepository<CoGiay, UUID> {

    //search
//    List<CoGiay> findCoGiayByTen(String tenCoGiay);
//
//    List<CoGiay> findCoGiayByTen(String tenCoGiay);
}
