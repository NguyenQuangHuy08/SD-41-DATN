package com.example.sd_41.service.SanPham;
import com.example.sd_41.model.CongDung;

import java.util.List;
import java.util.UUID;

public interface CongDungService {
    List<CongDung> getAll();
    void add(CongDung cd);
    void update(CongDung cd, UUID id);
    void delete(UUID id);
    CongDung getOne(UUID id);

}
