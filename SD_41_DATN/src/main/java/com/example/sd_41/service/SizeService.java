package com.example.sd_41.service;

import com.example.sd_41.model.Form;
import com.example.sd_41.model.Size;
import com.example.sd_41.repository.FormRepository;
import com.example.sd_41.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SizeService {
    @Autowired
    private SizeRepository sizeRepository;

    public List<Size> getAll(){
        return sizeRepository.findAll();
    }

    public Size getone(UUID id){
        return sizeRepository.findById(id).orElse(null);
    }


    public void add(Size size){
        sizeRepository.save(size);
    }

    public void delete(UUID id){
        sizeRepository.deleteById(id);
    }

    public void update(UUID id,Size size){
        Size size1 = sizeRepository.findById(id).get();
        if(size1 != null){
            size1.setSize(size.getSize());
            size1.setGhiChu(size.getGhiChu());
            size1.setNgaySua(size.getNgaySua());
            size1.setNgayTao(size.getNgayTao());
            size1.setTrangThai(size.getTrangThai());
            sizeRepository.save(size1);
        }
    }
}
