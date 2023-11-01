package com.example.sd_41.repository;

import com.example.sd_41.model.HuongDanBaoQuan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HuongDanBaoQuanRepository extends JpaRepository<HuongDanBaoQuan, UUID> {


}
