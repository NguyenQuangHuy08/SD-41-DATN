package com.example.sd_41.controller.HoaDon;

import com.example.sd_41.model.ChuongTrinhGiamGiaHoaDon;
import com.example.sd_41.repository.ChuongTrinhGiamGiaHoaDonRepository;
import jakarta.servlet.ServletContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/ChuongTrinhGiamGiaHoaDon")
public class ChuongTrinhGiamGiaHoaDonController {


    @Autowired
    ServletContext context;

    @Autowired
    private ChuongTrinhGiamGiaHoaDonRepository chuongTrinhGiamGiaHoaDonRepository;

    //Todo code list
    @GetMapping("list")
    public String showList(Model model){

      List<ChuongTrinhGiamGiaHoaDon> list = chuongTrinhGiamGiaHoaDonRepository.findAll();
      System.out.println(list.size());
      model.addAttribute("list",list);

      return "/HoaDon/ChuongTrinhGiamGiaHoaDon/list";

    }

    //Todo code create
    @GetMapping("create")
    public String showCreate(Model model){

          model.addAttribute("chuongTrinhGiamGiaHoaDon", new ChuongTrinhGiamGiaHoaDon());
          return "/HoaDon/ChuongTrinhGiamGiaHoaDon/create";

    }
    @PostMapping("create")
    public String saveCreate(Model model,
                             @Valid
                             @ModelAttribute("chuongTrinhGiamGiaHoaDon") ChuongTrinhGiamGiaHoaDon chuongTrinhGiamGiaHoaDon,
                             BindingResult result,
                             RedirectAttributes attributes){

        if(result.hasErrors()){

            model.addAttribute("er","Lỗi khi create");
            return "/HoaDon/ChuongTrinhGiamGiaHoaDon/create";

        }


        LocalDate ngayBatDau = LocalDate.now();
        LocalDate ngayKetThuc = LocalDate.now();
        LocalDate ngayTao = LocalDate.now();
        LocalDate ngaySua = LocalDate.now();

        String ngayBatDauToDate = ngayBatDau.toString();
        String ngayKetThucToDate = ngayKetThuc.toString();
        String ngayTaoToDate = ngayTao.toString();
        String ngaySuaToDate = ngaySua.toString();

        chuongTrinhGiamGiaHoaDon.setNgayBatDau(ngayBatDauToDate);
        chuongTrinhGiamGiaHoaDon.setNgayBatDau(ngayKetThucToDate);
        chuongTrinhGiamGiaHoaDon.setNgayBatDau(ngayTaoToDate);
        chuongTrinhGiamGiaHoaDon.setNgayBatDau(ngaySuaToDate);

        chuongTrinhGiamGiaHoaDonRepository.save(chuongTrinhGiamGiaHoaDon);
        attributes.addFlashAttribute("message", "Create chương trình giảm giá hóa đơn thành công !");

        return "redirect:/ChuongTrinhGiamGiaHoaDon/list";

    }

    //Todo code edit
    @GetMapping("edit/{Id_ChuongTrinhGiamGiaHoaDon}")
    public String showEdit(Model model,
                           @PathVariable UUID Id_ChuongTrinhGiamGiaHoaDon){

        model.addAttribute("product", chuongTrinhGiamGiaHoaDonRepository.findById(Id_ChuongTrinhGiamGiaHoaDon).orElse(null));
        return "/HoaDon/ChuongTrinhGiamGiaHoaDon/edit";

    }



}
