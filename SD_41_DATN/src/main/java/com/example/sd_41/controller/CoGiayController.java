package com.example.sd_41.controller;

import com.example.sd_41.model.CoGiay;
import com.example.sd_41.repository.CoGiayRepository;
import com.example.sd_41.service.CoGiayService;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableMBeanExport;
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
@RequestMapping("CoGiay")
public class CoGiayController {

    @Autowired
    private CoGiayService coGiayService;

    @Autowired
    private CoGiayRepository coGiayRepository;

    @Autowired
    ServletContext context;

    @GetMapping("list")
    public String viewCoGiay(Model model,
                             @RequestParam(name = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
                             @RequestParam(name = "pageSize", required = false, defaultValue = "5") Integer pageSize)
    {
        List<CoGiay> listCG = coGiayRepository.findAll();
        model.addAttribute("listCG", listCG);

        Pageable pageable = PageRequest.of(pageNumber-1, pageSize);
        Page<CoGiay> page = coGiayRepository.findAll(pageable);

        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("listPage", page.getContent());

        return "/CoGiay/list";
    }

    @GetMapping("create")
    public String createPage(Model model){
        model.addAttribute("coGiay", new CoGiay());
        return "/CoGiay/create";
    }

    @PostMapping("create")
    public String create(Model model, @ModelAttribute("coGiay") CoGiay coGiay, BindingResult result, RedirectAttributes attributes){
        if (result.hasErrors()){
            return "/CoGiay/create";
        }

        if(coGiay.getTenCoGiay() == null || coGiay.getTenCoGiay().isEmpty() || coGiay.getTenCoGiay().trim().length() == 0){
            model.addAttribute("checkCoGiayNotNull", "Tên cỡ giầy không được để trống");
            return "/CoGiay/create";
        }

        if(coGiay.getTenCoGiay().matches("^\\d.*") || !coGiay.getTenCoGiay().matches(".*[a-zA-Z].*")){
            model.addAttribute("checkCoGiayHopLe", "Tên cỡ giầy không hợp lệ");
            return "/CoGiay/create";
        }

        LocalDate ngayTao = LocalDate.now();
        LocalDate ngaySua = LocalDate.now();

        String ngayTaoDate = ngayTao.toString();
        String ngaySuaDate = ngaySua.toString();

        coGiayRepository.save(coGiay);
        attributes.addFlashAttribute("message", "Thêm thành công!");
        return "redirect:/CoGiay/list";
    }

    @GetMapping("edit/{id}")
    public String editPage(Model model, @PathVariable UUID id){
        CoGiay coGiay = coGiayRepository.findById(id).orElse(null);
        if(coGiay == null){
            model.addAttribute("messageFind", "Không tìm thấy id có mã: " +id);
            return "/CoGiay/list";
        }

        model.addAttribute("coGiay", coGiayRepository.findById(id).orElse(null));
        return "/CoGiay/edit";
    }

//    @GetMapping("/search")
//    public String searchCoGiay(@RequestParam(value = "tenCoGiay", required = false) String tenCoGiay, Model model){
//        List<CoGiay> listPage;
//        if(tenCoGiay != null){
//            listPage = coGiayService.findCoGiay(tenCoGiay);
//        }else {
//            listPage = coGiayRepository.findAll();
//        }
//
//        if (!listPage.isEmpty()){
//            model.addAttribute("listPage", listPage);
//        }else {
//            model.addAttribute("message", "Không tìm thấy kết quả");
//            listPage = coGiayRepository.findAll();
//        }
//
//        model.addAttribute("listPage", listPage);
//        return "/CoGiay/list";
//    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") CoGiay coGiay){
        coGiayRepository.delete(coGiay);
        return "redirect:/CoGiay/list";
    }
}
