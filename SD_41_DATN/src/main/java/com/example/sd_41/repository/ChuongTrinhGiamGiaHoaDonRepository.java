package com.example.sd_41.repository;

import com.example.sd_41.model.ChuongTrinhGiamGiaHoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ChuongTrinhGiamGiaHoaDonRepository extends JpaRepository<ChuongTrinhGiamGiaHoaDon, UUID> {

}
