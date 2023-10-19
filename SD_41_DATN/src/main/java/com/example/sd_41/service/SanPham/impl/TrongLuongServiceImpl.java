package com.example.sd_41.service.SanPham.impl;


import com.example.sd_41.model.TrongLuong;
import com.example.sd_41.repository.SanPham.TrongLuongRepository;
import com.example.sd_41.service.SanPham.TrongLuongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.UUID;
@Service
public class TrongLuongServiceImpl implements TrongLuongService {
    @Autowired
    private TrongLuongRepository trongLuongRepository;
    @Override
    public List<TrongLuong> getAll() {
        return trongLuongRepository.findAll() ;
    }

    @Override
    public void add(TrongLuong cd) {
    trongLuongRepository.save(cd);
    }

    @Override
    public void update(TrongLuong cd, UUID id) {

        TrongLuong cd1 = trongLuongRepository.findById(id).get();
        if(cd1 != null){
            cd1.setTenTrongLuong(cd.getTenTrongLuong());
            cd1.setGhiChu(cd.getGhiChu());
            cd1.setNgaySua(cd.getNgaySua());
            cd1.setNgayTao(cd.getNgayTao());
            cd1.setTrangThai(cd.getTrangThai());
            trongLuongRepository.save(cd1);
        }    }


    @Override
    public void delete(UUID id) {
    trongLuongRepository.deleteById(id);
    }

    @Override
    public TrongLuong getOne(UUID id) {
        return trongLuongRepository.findById(id).get();
    }
}
