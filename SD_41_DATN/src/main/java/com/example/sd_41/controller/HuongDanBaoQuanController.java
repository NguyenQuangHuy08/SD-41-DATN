package com.example.sd_41.controller;

import com.example.sd_41.model.HuongDanBaoQuan;
import com.example.sd_41.repository.HuongDanBaoQuanRepository;
import com.example.sd_41.service.HuongDanBaoQuanService;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("HuongDanBaoQuan")
public class HuongDanBaoQuanController {
    @Autowired
        private HuongDanBaoQuanService huongDanBaoQuanService;

    @Autowired
    private HuongDanBaoQuanRepository huongDanBaoQuanRepository;

    @Autowired
    ServletContext context;

    @GetMapping("list")
    public String viewCoGiay(Model model,
                             @RequestParam(name = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
                             @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize){
        List<HuongDanBaoQuan> listMS = huongDanBaoQuanRepository.findAll();
        model.addAttribute("listMS", listMS);

        Pageable pageable = PageRequest.of(pageNumber -1, pageSize);
        Page<HuongDanBaoQuan> page = huongDanBaoQuanRepository.findAll(pageable);

        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("listPage", page.getContent());

        return "/HuongDanBaoQuan/list";
    }

    @GetMapping("create")
    public String createPage(Model model){
        model.addAttribute("huongDanBaoQuan", new HuongDanBaoQuan());
        return "/HuongDanBaoQuan/create";
    }

    @PostMapping("create")
    public String create(Model model, @ModelAttribute("huongDanBaoQuan") HuongDanBaoQuan huongDanBaoQuan, BindingResult result, RedirectAttributes attributes){
        if (result.hasErrors()){
            return "/HuongDanBaoQuan/create";
        }

        if(huongDanBaoQuan.getTenHuongDanBaoQuan() == null || huongDanBaoQuan.getTenHuongDanBaoQuan().isEmpty() || huongDanBaoQuan.getTenHuongDanBaoQuan().trim().length() == 0){
            model.addAttribute("checkHuongDanBaoQuanNotNull", "Tên hướng dẫn bảo quản không được để trống");
            return "/HuongDanBaoQuan/create";
        }

        if(huongDanBaoQuan.getTenHuongDanBaoQuan().matches("^\\d.*") || !huongDanBaoQuan.getTenHuongDanBaoQuan().matches(".*[a-zA-Z].*")){
            model.addAttribute("checkHuongDanBaoQuanHopLe", "Tên hướng dẫn bảo quản không hợp lệ");
            return "/HuongDanBaoQuan/create";
        }

        LocalDate ngayTao = LocalDate.now();
        LocalDate ngaySua = LocalDate.now();

        String ngayTaoDate = ngayTao.toString();
        String ngaySuaDate = ngaySua.toString();

        huongDanBaoQuanRepository.save(huongDanBaoQuan);
        attributes.addFlashAttribute("message", "Thêm thành công!");
        return "redirect:/HuongDanBaoQuan/list";
    }

    @GetMapping("edit/{id}")
    public String editPage(Model model, @PathVariable UUID id){
        HuongDanBaoQuan huongDanBaoQuan = huongDanBaoQuanRepository.findById(id).orElse(null);
        if(huongDanBaoQuan == null){
            model.addAttribute("messageFind", "Không tìm thấy id có mã: " +id);
            return "/HuongDanBaoQuan/list";
        }

        model.addAttribute("huongDanBaoQuan", huongDanBaoQuanRepository.findById(id).orElse(null));
        return "/HuongDanBaoQuan/edit";
    }

//    @GetMapping("/search")
//    public String searchMauSac(@RequestParam(value = "tenMauSac", required = false) String tenMauSac, Model model){
//        List<MauSac> listPage;
//        if(tenMauSac != null){
//            listPage =mauSacRepository.findMauSacByTen(tenMauSac);
//        }else {
//            listPage = mauSacRepository.findAll();
//        }
//
//        if (!listPage.isEmpty()){
//            model.addAttribute("listPage", listPage);
//        }else {
//            model.addAttribute("message", "Không tìm thấy kết quả");
//            listPage = mauSacRepository.findAll();
//        }
//
//        model.addAttribute("listPage", listPage);
//        return "/MauSac/list";
//    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") HuongDanBaoQuan huongDanBaoQuan){
        huongDanBaoQuanRepository.delete(huongDanBaoQuan);
        return "redirect:/HuongDanBaoQuan/list";
    }
}
