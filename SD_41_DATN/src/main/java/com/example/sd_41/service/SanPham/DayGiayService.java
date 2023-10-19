package com.example.sd_41.service.SanPham;

import com.example.sd_41.model.DayGiay;

import java.util.List;
import java.util.UUID;

public interface DayGiayService {
    List<DayGiay> getAll();
    void add(DayGiay cd);
    void update(DayGiay cd, UUID id);
    void delete(UUID id);
    DayGiay getOne(UUID id);
}
