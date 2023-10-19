package com.example.sd_41.service.SanPham.impl;

import com.example.sd_41.model.CongDung;
import com.example.sd_41.repository.SanPham.CongDungRepository;
import com.example.sd_41.service.SanPham.CongDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CongDungServiceImpl implements CongDungService {
    @Autowired
    private CongDungRepository congDungRepository;
    @Override
    public List<CongDung> getAll() {
        return congDungRepository.findAll();
    }

    @Override
    public void add(CongDung cd) {
         congDungRepository.save(cd);
    }

    @Override
    public void update(CongDung cd, UUID id) {
        CongDung cd1 = congDungRepository.findById(id).get();
        if(cd1 != null){
            cd1.setTenCongDung(cd.getTenCongDung());
            cd1.setGhiChu(cd.getGhiChu());
            cd1.setNgaySua(cd.getNgaySua());
            cd1.setNgayTao(cd.getNgayTao());
            cd1.setTrangThai(cd.getTrangThai());
            congDungRepository.save(cd1);
        }
    }

    @Override
    public void delete(UUID id) {
    congDungRepository.deleteById(id);
    }

    @Override
    public CongDung getOne(UUID id) {
        return congDungRepository.findById(id).get();
    }
}
