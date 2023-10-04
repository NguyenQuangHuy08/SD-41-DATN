package com.example.sd_41.controller;

import com.example.sd_41.model.ChatLieu;
import com.example.sd_41.model.Form;
import com.example.sd_41.service.ChatLieuService;
import com.example.sd_41.service.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
public class FormController {
    @Autowired
    private FormService formService;
    List<Form> formList;

    @GetMapping("/form/hien-thi")
    private String getAll(Model model){
        List<Form> list= formService.getAll();
        model.addAttribute("form",list);
        return "Form/forms";
    }

    @GetMapping("/form/view-update/{id}")
    public String viewUpadte(@PathVariable UUID id, Model model){
        Form form = formService.getone(id);
        model.addAttribute("fm",form);
        return "Form/viewUpadte";
    }

    @PostMapping("/form/add")
    public String Add(@RequestParam String tenForm,
                      @RequestParam String ngayTao,
                      @RequestParam String ngaySua,
                      @RequestParam String ghiChu,
                      @RequestParam String trangThai
    ){
        Form form = Form.builder()
                .ghiChu(ghiChu)
                .tenForm(tenForm)
                .ngayTao(ngayTao)
                .ngaySua(ngaySua)
                .trangThai(Integer.valueOf(trangThai))
                .build();
        formService.add(form);
        return "redirect:/form/hien-thi";
    }

    @PostMapping("/form/update/{id}")
    public String update(@RequestParam UUID id,
                         @RequestParam String tenForm,
                         @RequestParam String ngayTao,
                         @RequestParam String ngaySua,
                         @RequestParam String ghiChu,
                         @RequestParam String trangThai
    ){
        Form form = Form.builder()
                .ghiChu(ghiChu)
                .tenForm(tenForm)
                .ngayTao(ngayTao)
                .ngaySua(ngaySua)
                .trangThai(Integer.valueOf(trangThai))
                .build();
        formService.update(id,form);
        return "redirect:/form/hien-thi";
    }
    @GetMapping("/form/delete/{id}")
    public String delete(@PathVariable UUID id){
        formService.delete(id);
        return "redirect:/form/hien-thi";
    }

}
