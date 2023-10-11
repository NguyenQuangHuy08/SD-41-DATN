package com.example.sd_41.controller;

import com.example.sd_41.model.MauSac;
import com.example.sd_41.repository.MauSacRepository;
import com.example.sd_41.service.MauSacService;
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
@RequestMapping("MauSac")
public class MauSacController {

    @Autowired
    private MauSacService mauSacService;

    @Autowired
    private MauSacRepository mauSacRepository;

    @Autowired
    ServletContext context;

    @GetMapping("list")
    public String viewCoGiay(Model model,
                             @RequestParam(name = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
                             @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize){
        List<MauSac> listMS = mauSacRepository.findAll();
        model.addAttribute("listMS", listMS);

        Pageable pageable = PageRequest.of(pageNumber -1, pageSize);
        Page<MauSac> page = mauSacRepository.findAll(pageable);

        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("listPage", page.getContent());

        return "/MauSac/list";
    }

    @GetMapping("create")
    public String createPage(Model model){
        model.addAttribute("mauSac", new MauSac());
        return "/MauSac/create";
    }

    @PostMapping("create")
    public String create(Model model, @ModelAttribute("mauSac") MauSac mauSac, BindingResult result, RedirectAttributes attributes){
        if (result.hasErrors()){
            return "/MauSac/create";
        }

        if(mauSac.getTenMauSac() == null || mauSac.getTenMauSac().isEmpty() || mauSac.getTenMauSac().trim().length() == 0){
            model.addAttribute("checkMauSacNotNull", "Tên màu sắc không được để trống");
            return "/MauSac/create";
        }

        if(mauSac.getTenMauSac().matches("^\\d.*") || !mauSac.getTenMauSac().matches(".*[a-zA-Z].*")){
            model.addAttribute("checkMauSacHopLe", "Tên màu sắc không hợp lệ");
            return "/MauSac/create";
        }

        LocalDate ngayTao = LocalDate.now();
        LocalDate ngaySua = LocalDate.now();

        String ngayTaoDate = ngayTao.toString();
        String ngaySuaDate = ngaySua.toString();

        mauSacRepository.save(mauSac);
        attributes.addFlashAttribute("message", "Thêm thành công!");
        return "redirect:/MauSac/list";
    }

    @GetMapping("edit/{id}")
    public String editPage(Model model, @PathVariable UUID id){
        MauSac mauSac = mauSacRepository.findById(id).orElse(null);
        if(mauSac == null){
            model.addAttribute("messageFind", "Không tìm thấy id có mã: " +id);
            return "/MauSac/list";
        }

        model.addAttribute("mauSac", mauSacRepository.findById(id).orElse(null));
        return "/MauSac/edit";
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
    public String delete(@PathVariable("id") MauSac mauSac){
        mauSacRepository.delete(mauSac);
        return "redirect:/MauSac/list";
    }
}
