package com.example.sd_41.service;

import com.example.sd_41.model.CoGiay;
import com.example.sd_41.repository.CoGiayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoGiayService {

    @Autowired
    private CoGiayRepository coGiayRepository;

    //Tìm kiếm
//    public List<CoGiay> findCoGiay(String tenCoGiay){
//        if (tenCoGiay != null){
//            return coGiayRepository.findCoGiayByTen(tenCoGiay);
//        }else {
//            return coGiayRepository.findAll();
//        }
//    }
}
