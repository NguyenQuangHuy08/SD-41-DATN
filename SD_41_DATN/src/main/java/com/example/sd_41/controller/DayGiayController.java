package com.example.sd_41.controller;

import com.example.sd_41.repository.SanPham.DayGiayRepository;
import com.example.sd_41.service.SanPham.DayGiayService;
import com.example.sd_41.service.SanPham.impl.DayGiayServiceImpl;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import com.example.sd_41.model.DayGiay;

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
public class DayGiayController {
    @Autowired
    private DayGiayServiceImpl dayGiayService;
    List<DayGiay> list;

    @GetMapping("/day-giay/hien-thi")
    private String getAll(Model model){
        List<DayGiay> list= dayGiayService.getAll();
        model.addAttribute("dayGiay",list);
        return "DayGiay/DayGiay";
    }

    @GetMapping("/day-giay/view-update/{id}")
    public String viewUpadte(@PathVariable UUID id, Model model){
        DayGiay dayGiay = dayGiayService.getOne(id);
        model.addAttribute("cd",dayGiay);
        return "DayGiay/viewUpdate";
    }

    @PostMapping("/day-giay/add")
    public String Add(@RequestParam String tenCongDung,
                      @RequestParam String chieuDaiDayGiay,
                      @RequestParam String ngayTao,
                      @RequestParam String ngaySua,
                      @RequestParam String ghiChu,
                      @RequestParam String trangThai
    ){
        DayGiay congDung = DayGiay.builder()
                .ghiChu(ghiChu)
                .chieuDaiDayGiay(chieuDaiDayGiay)
                .tenDayGiay(tenCongDung)
                .ngayTao(ngayTao)
                .ngaySua(ngaySua)
                .trangThai(Integer.valueOf(trangThai))
                .build();
        dayGiayService.add(congDung);
        return "redirect:/day-giay/hien-thi";
    }

    @PostMapping("/day-giay/update/{id}")
    public String update(@RequestParam UUID id,
                         @RequestParam String tenDayGiay,
                         @RequestParam String chieuDaiDayGiay,
                         @RequestParam String ngayTao,
                         @RequestParam String ngaySua,
                         @RequestParam String ghiChu,
                         @RequestParam String trangThai
    ){
        DayGiay congDung = DayGiay.builder()
                .ghiChu(ghiChu)
                .tenDayGiay(tenDayGiay)
                .chieuDaiDayGiay(chieuDaiDayGiay)
                .ngayTao(ngayTao)
                .ngaySua(ngaySua)
                .trangThai(Integer.valueOf(trangThai))
                .build();
        dayGiayService.update(congDung,id);
        return "redirect:/day-giay/hien-thi";
    }
    @GetMapping("/day-giay/delete/{id}")
    public String delete(@PathVariable UUID id){
        dayGiayService.delete(id);
        return "redirect:/day-giay/hien-thi";
    }

}

