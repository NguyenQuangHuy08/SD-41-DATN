package com.example.sd_41.service;


import com.example.sd_41.model.Form;
import com.example.sd_41.repository.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FormService {
    @Autowired
    private FormRepository formRepository;

    public List<Form> getAll(){
        return formRepository.findAll();
    }

    public Form getone(UUID id){
        return formRepository.findById(id).orElse(null);
    }


    public void add(Form form){
        formRepository.save(form);
    }

    public void delete(UUID id){
        formRepository.deleteById(id);
    }

    public void update(UUID id,Form form){
        Form form1 = formRepository.findById(id).get();
        if(form1 != null){
            form1.setTenForm(form.getTenForm());
            form1.setGhiChu(form.getGhiChu());
            form1.setNgaySua(form.getNgaySua());
            form1.setNgayTao(form.getNgayTao());
            form1.setTrangThai(form.getTrangThai());
            formRepository.save(form1);
        }
    }
}
