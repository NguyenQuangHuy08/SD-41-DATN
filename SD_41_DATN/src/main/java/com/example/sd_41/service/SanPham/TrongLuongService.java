package com.example.sd_41.service.SanPham;

import com.example.sd_41.model.TrongLuong;

import java.util.List;
import java.util.UUID;

public interface TrongLuongService {
    List<TrongLuong> getAll();
    void add(TrongLuong cd);
    void update(TrongLuong  cd, UUID id);
    void delete(UUID id);
    TrongLuong getOne(UUID id);
}
