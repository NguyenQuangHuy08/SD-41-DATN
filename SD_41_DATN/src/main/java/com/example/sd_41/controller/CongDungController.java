package com.example.sd_41.controller;
import com.example.sd_41.repository.SanPham.CongDungRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.example.sd_41.model.CongDung;
import com.example.sd_41.service.SanPham.impl.CongDungServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import java.util.UUID;
import java.io.IOException;

@Controller
public class CongDungController {
    @Autowired
    private CongDungServiceImpl congDungService;
    List<CongDung> list;

    @GetMapping("/cong-dung/hien-thi")
    private String getAll(Model model){
        List<CongDung> list= congDungService.getAll();
        model.addAttribute("congDung",list);
        return "CongDung/CongDung";
    }

    @GetMapping("/cong-dung/view-update/{id}")
    public String viewUpadte(@PathVariable UUID id, Model model){
        CongDung congDung = congDungService.getOne(id);
        model.addAttribute("cd",congDung);
        return "CongDung/viewUpdate";
    }

    @PostMapping("/cong-dung/add")
    public String Add(@RequestParam String tenCongDung,
                      @RequestParam String ngayTao,
                      @RequestParam String ngaySua,
                      @RequestParam String ghiChu,
                      @RequestParam String trangThai
    ){
        CongDung congDung = CongDung.builder()
                .ghiChu(ghiChu)
                .tenCongDung(tenCongDung)
                .ngayTao(ngayTao)
                .ngaySua(ngaySua)
                .trangThai(Integer.valueOf(trangThai))
                .build();
        congDungService.add(congDung);
        return "redirect:/cong-dung/hien-thi";
    }

    @PostMapping("/cong-dung/update/{id}")
    public String update(@RequestParam UUID id,
                         @RequestParam String tenCongDung,
                         @RequestParam String ngayTao,
                         @RequestParam String ngaySua,
                         @RequestParam String ghiChu,
                         @RequestParam String trangThai
    ){
        CongDung congDung = CongDung.builder()
                .ghiChu(ghiChu)
                .tenCongDung(tenCongDung)
                .ngayTao(ngayTao)
                .ngaySua(ngaySua)
                .trangThai(Integer.valueOf(trangThai))
                .build();
        congDungService.update(congDung,id);
        return "redirect:/cong-dung/hien-thi";
    }
    @GetMapping("/cong-dung/delete/{id}")
    public String delete(@PathVariable UUID id){
        congDungService.delete(id);
        return "redirect:/cong-dung/hien-thi";
    }

}

