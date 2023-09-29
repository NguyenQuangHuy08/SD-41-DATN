package com.example.sd_41.repository.HoaDon.ChuongTrinhGiamGiaHoaDon;

import com.example.sd_41.model.ChuongTrinhGiamGiaHoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChuongTrinhGiamGiaHoaDonRepository extends JpaRepository<ChuongTrinhGiamGiaHoaDon, UUID> {


}
