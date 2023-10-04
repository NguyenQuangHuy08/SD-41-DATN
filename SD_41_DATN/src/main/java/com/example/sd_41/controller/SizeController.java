package com.example.sd_41.controller;

import com.example.sd_41.model.Form;
import com.example.sd_41.model.Size;
import com.example.sd_41.repository.SizeRepository;
import com.example.sd_41.service.FormService;
import com.example.sd_41.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
public class SizeController {
    @Autowired
    private SizeService sizeService;
    private SizeRepository repository;

    @GetMapping("/size/hien-thi")
    private String getAll(Model model){
        List<Size> list= sizeService.getAll();
        model.addAttribute("size",list);
        return "Size/sizes";
    }

    @GetMapping("/size/view-update/{id}")
    public String viewUpadte(@PathVariable UUID id, Model model){
        Size size = sizeService.getone(id);
        model.addAttribute("sz",size);
        return "Size/viewUpadte";
    }

    @PostMapping("/size/add")
    public String Add(@RequestParam String size,
                      @RequestParam String ngayTao,
                      @RequestParam String ngaySua,
                      @RequestParam String ghiChu,
                      @RequestParam String trangThai
    ){
        Size size1 = Size.builder()
                .ghiChu(ghiChu)
                .size(Integer.valueOf(size))
                .ngayTao(ngayTao)
                .ngaySua(ngaySua)
                .trangThai(Integer.valueOf(trangThai))
                .build();
        sizeService.add(size1);
        return "redirect:/size/hien-thi";
    }

    @PostMapping("/size/update/{id}")
    public String update(@RequestParam UUID id,
                         @RequestParam String size,
                         @RequestParam String ngayTao,
                         @RequestParam String ngaySua,
                         @RequestParam String ghiChu,
                         @RequestParam String trangThai
    ){
        Size size1 = Size.builder()
                .ghiChu(ghiChu)
                .size(Integer.valueOf(size))
                .ngayTao(ngayTao)
                .ngaySua(ngaySua)
                .trangThai(Integer.valueOf(trangThai))
                .build();
        sizeService.update(id,size1);
        return "redirect:/size/hien-thi";
    }
    @GetMapping("/size/delete/{id}")
    public String delete(@PathVariable UUID id){
        sizeService.delete(id);
        return "redirect:/size/hien-thi";
    }
//    @GetMapping
//    public String view(Model model
//            , @RequestParam(defaultValue = "1") int page
//            , @RequestParam(required = false) String id ) {
//
//        Page<Size> pageSize;
//
//        if (page < 1) page = 1;
//
//        Pageable pageable = PageRequest.of(page - 1, 2);
//        if (id == null || id.isBlank()) {
//            pageSize = repository.findAll(pageable);
//        } else {
//            pageSize = repository.findByidContains(id, pageable);
//        }
//
//        model.addAttribute("page", pageSize);
//        return "size/hien-thi";
//    }

}
