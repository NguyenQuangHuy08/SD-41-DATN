package com.example.sd_41.repository.SanPham;
import com.example.sd_41.model.TrongLuong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface TrongLuongRepository extends JpaRepository<TrongLuong, UUID> {
}
