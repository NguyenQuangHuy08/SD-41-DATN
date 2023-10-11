package com.example.sd_41.repository;

import com.example.sd_41.model.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface MauSacRepository extends JpaRepository<MauSac, UUID> {

    //search
//    List<MauSac> findMauSacByTen(String tenMauSac);
}
