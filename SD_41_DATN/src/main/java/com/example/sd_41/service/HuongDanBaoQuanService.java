package com.example.sd_41.service;

import com.example.sd_41.repository.HuongDanBaoQuanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HuongDanBaoQuanService {

    @Autowired
    private HuongDanBaoQuanRepository huongDanBaoQuanRepository;

}
