package com.example.sd_41.service.SanPham.impl;

import com.example.sd_41.model.DayGiay;
import com.example.sd_41.repository.SanPham.DayGiayRepository;
import com.example.sd_41.service.SanPham.DayGiayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class DayGiayServiceImpl implements DayGiayService {
    @Autowired
    private DayGiayRepository dayGiayRepository;

    @Override
    public List<DayGiay> getAll() {
        return dayGiayRepository.findAll();
    }

    @Override
    public void add(DayGiay cd) {
        dayGiayRepository.save(cd);
    }

    @Override
    public void update(DayGiay cd, UUID id) {
        DayGiay cd1 = dayGiayRepository.findById(id).get();
        if(cd1 != null){
            cd1.setTenDayGiay(cd.getTenDayGiay());
            cd1.setChieuDaiDayGiay(cd.getChieuDaiDayGiay());
            cd1.setGhiChu(cd.getGhiChu());
            cd1.setNgaySua(cd.getNgaySua());
            cd1.setNgayTao(cd.getNgayTao());
            cd1.setTrangThai(cd.getTrangThai());
            dayGiayRepository.save(cd1);
        }
    }

    @Override
    public void delete(UUID id) {
        dayGiayRepository.deleteById(id);
    }

    @Override
    public DayGiay getOne(UUID id) {
        return dayGiayRepository.findById(id).get();
    }
}
