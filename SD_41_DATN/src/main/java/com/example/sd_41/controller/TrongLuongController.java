package com.example.sd_41.controller;

import com.example.sd_41.model.TrongLuong;
import com.example.sd_41.repository.SanPham.CongDungRepository;
import com.example.sd_41.service.SanPham.impl.TrongLuongServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
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
public class TrongLuongController {
    @Autowired
    private TrongLuongServiceImpl trongLuongService;
    List<TrongLuong> list;

    @GetMapping("/trong-luong/hien-thi")
    private String getAll(Model model){
        List<TrongLuong> list= trongLuongService.getAll();
        model.addAttribute("trongLuong",list);
        return "TrongLuong/TrongLuong";
    }

    @GetMapping("/trong-luong/view-update/{id}")
    public String viewUpadte(@PathVariable UUID id, Model model){
        TrongLuong trongLuong = trongLuongService.getOne(id);
        model.addAttribute("cd",trongLuong);
        return "TrongLuong/viewUpdate";
    }

    @PostMapping("/trong-luong/add")
    public String Add(@RequestParam String tenTrongLuong,
                      @RequestParam String ngayTao,
                      @RequestParam String ngaySua,
                      @RequestParam String ghiChu,
                      @RequestParam String trangThai
    ){
        TrongLuong trongLuong = TrongLuong.builder()
                .ghiChu(ghiChu)
                .tenTrongLuong(tenTrongLuong)
                .ngayTao(ngayTao)
                .ngaySua(ngaySua)
                .trangThai(Integer.valueOf(trangThai))
                .build();
        trongLuongService.add(trongLuong);
        return "redirect:/trong-luong/hien-thi";
    }

    @PostMapping("/trong-luong/update/{id}")
    public String update(@RequestParam UUID id,
                         @RequestParam String tenTrongLuong,
                         @RequestParam String ngayTao,
                         @RequestParam String ngaySua,
                         @RequestParam String ghiChu,
                         @RequestParam String trangThai
    ){
        TrongLuong trongLuong = TrongLuong.builder()
                .ghiChu(ghiChu)
                .tenTrongLuong(tenTrongLuong)
                .ngayTao(ngayTao)
                .ngaySua(ngaySua)
                .trangThai(Integer.valueOf(trangThai))
                .build();
        trongLuongService.update(trongLuong,id);
        return "redirect:/trong-luong/hien-thi";
    }
    @GetMapping("/trong-luong/delete/{id}")
    public String delete(@PathVariable UUID id){
        trongLuongService.delete(id);
        return "redirect:/trong-luong/hien-thi";
    }

}

