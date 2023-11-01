package com.example.sd_41.service;

import com.example.sd_41.repository.LotGiayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LotGiayService {
    @Autowired
    private LotGiayRepository lotGiayRepository;
}
