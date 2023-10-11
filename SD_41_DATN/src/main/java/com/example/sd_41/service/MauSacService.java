package com.example.sd_41.service;

import com.example.sd_41.model.MauSac;
import com.example.sd_41.repository.MauSacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MauSacService {

    @Autowired
    private MauSacRepository mauSacRepository;

//    public List<MauSac> findMauSac(String tenMauSac) {
//        if (tenMauSac != null){
//            return mauSacRepository.findMauSacByTen(tenMauSac);
//        }else {
//            return mauSacRepository.findAll();
//        }
//    }
}
