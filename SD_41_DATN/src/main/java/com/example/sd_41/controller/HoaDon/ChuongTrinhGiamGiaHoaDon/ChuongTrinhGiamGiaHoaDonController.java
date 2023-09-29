package com.example.sd_41.controller.HoaDon.ChuongTrinhGiamGiaHoaDon;

import com.example.sd_41.model.ChuongTrinhGiamGiaHoaDon;
import com.example.sd_41.repository.HoaDon.ChuongTrinhGiamGiaHoaDon.ChuongTrinhGiamGiaHoaDonRepository;
import jakarta.servlet.ServletContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
    public String viewSanPham(Model model,
                              @RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                              @RequestParam(name = "pageSize", required = false, defaultValue = "3") Integer pageSize

    ){

        List<ChuongTrinhGiamGiaHoaDon> lstSP = chuongTrinhGiamGiaHoaDonRepository.findAll();
        model.addAttribute("lstSP", lstSP);

        Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
        Page<ChuongTrinhGiamGiaHoaDon> page = chuongTrinhGiamGiaHoaDonRepository.findAll(pageable);


        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("listPage", page.getContent());

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

            return "/HoaDon/ChuongTrinhGiamGiaHoaDon/create";

        }

        //Check tên sản phẩm
        if (chuongTrinhGiamGiaHoaDon.getTenChuongTrinh() == null
                || chuongTrinhGiamGiaHoaDon.getTenChuongTrinh().isEmpty()
                || chuongTrinhGiamGiaHoaDon.getTenChuongTrinh().trim().length()==0) {
            model.addAttribute("erCheckTenSanPham", "Tên sản phẩm không được trống");
            return "/HoaDon/ChuongTrinhGiamGiaHoaDon/create";
        }
        //Check số lượng
        if(chuongTrinhGiamGiaHoaDon.getSoLuongSanPham() == null
                || chuongTrinhGiamGiaHoaDon.getSoLuongSanPham().trim().length()==0
                || chuongTrinhGiamGiaHoaDon.getSoLuongSanPham().isEmpty()){

            model.addAttribute("erCheckSoLuong", "Số lượng không được trống");
            return "/HoaDon/ChuongTrinhGiamGiaHoaDon/create";

        }
        try {
            int soLuong = Integer.parseInt(chuongTrinhGiamGiaHoaDon.getSoLuongSanPham());
            if (soLuong <= 1) {
                model.addAttribute("erCheckSoLuongNumber", "Số lượng phải lớn hơn 1");
                return "/HoaDon/ChuongTrinhGiamGiaHoaDon/create";
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            model.addAttribute("erCheckSoLuongString", "Số lượng phải là một số");
            return "/HoaDon/ChuongTrinhGiamGiaHoaDon/create";
        }
        //Check phần trăm giảm
        if(chuongTrinhGiamGiaHoaDon.getPhanTramGiam() == null
            || chuongTrinhGiamGiaHoaDon.getPhanTramGiam().trim().length()==0
            || chuongTrinhGiamGiaHoaDon.getPhanTramGiam().isEmpty()){

            model.addAttribute("erCheckPhanTramGiam", "Phần trăm giảm không được trống");
            return "/HoaDon/ChuongTrinhGiamGiaHoaDon/create";

        }
        try{

            int phanTramGiam = Integer.parseInt(chuongTrinhGiamGiaHoaDon.getPhanTramGiam());
            if(phanTramGiam <=4){

                model.addAttribute("erCheckPhanTramGiamNumber","Phần trăm giảm phải lớn hơn 4");
                return "/HoaDon/ChuongTrinhGiamGiaHoaDon/create";

            }
        }catch (NumberFormatException e){

             e.printStackTrace();
             model.addAttribute("erCheckPhanTramGiamString","Phần trăm giảm phải là số!");
             return "/HoaDon/ChuongTrinhGiamGiaHoaDon/create";

        }
        //Check số tiền hóa đơn cần đạt
        if( chuongTrinhGiamGiaHoaDon.getSoTienHoaDon() == null
//                || chuongTrinhGiamGiaHoaDon.getSoTienHoaDon().compareTo(BigDecimal.ZERO)==0
                || chuongTrinhGiamGiaHoaDon.getSoTienHoaDon().toString().isEmpty()
                || chuongTrinhGiamGiaHoaDon.getSoTienHoaDon().toString().trim().length()==0 ){

            model.addAttribute("erCheckSoTienHoaDon","Không được để trống số tiền !");
            return "/HoaDon/ChuongTrinhGiamGiaHoaDon/create";

        } else{
            try {

                BigDecimal soTienHoaDon = chuongTrinhGiamGiaHoaDon.getSoTienHoaDon();
                int soTien = soTienHoaDon.intValue();
                if(soTien <50000){

                    model.addAttribute("erCheckNumber","Số tiền hóa đơn cần đạt phải là số và lớn hơn hoặc bằng 500.000 VNĐ");
                    return "/HoaDon/ChuongTrinhGiamGiaHoaDon/create";

                }
            }catch (NumberFormatException e){

                    e.printStackTrace();
                    model.addAttribute("erCheckNumberString","Số tiền hóa đơn đạt được phải là số !");
                  return "/HoaDon/ChuongTrinhGiamGiaHoaDon/create";

            }
        }

        //Ngày kết thúc sẽ hết hạn sau 5 ngày
        LocalDate ngayBatDau = LocalDate.now();
//        LocalDate ngayKetThuc = LocalDate.now();
        LocalDate ngayKetThuc = ngayBatDau.plus(5, ChronoUnit.DAYS);
        LocalDate ngaySua = LocalDate.now();

        String ngayBatDauToDate = ngayBatDau.toString();
        String ngayKetThucToDate = ngayKetThuc.toString();
        String ngaySuaToDate = ngaySua.toString();

        chuongTrinhGiamGiaHoaDon.setNgayBatDau(ngayBatDauToDate);
        chuongTrinhGiamGiaHoaDon.setNgayKetThuc(ngayKetThucToDate);
        chuongTrinhGiamGiaHoaDon.setNgayTao(ngayBatDauToDate);
        chuongTrinhGiamGiaHoaDon.setNgaySua(ngaySuaToDate);

        chuongTrinhGiamGiaHoaDonRepository.save(chuongTrinhGiamGiaHoaDon);
        attributes.addFlashAttribute("message", "Create chương trình giảm giá hóa đơn thành công !");

        return "redirect:/ChuongTrinhGiamGiaHoaDon/list";

    }

    //Todo code edit
    @GetMapping("edit/{id}")
    public String showEdit(Model model,
                           @PathVariable
                           UUID id){
        ChuongTrinhGiamGiaHoaDon chuongTrinhGiamGiaHoaDon = chuongTrinhGiamGiaHoaDonRepository.findById(id).orElse(null);

        if(chuongTrinhGiamGiaHoaDon ==null){

                model.addAttribute("erFind","Không tìm thấy id có mã: "+id);
            return "/HoaDon/ChuongTrinhGiamGiaHoaDon/list";

        }

        model.addAttribute("chuongTrinhGiamGiaHoaDon", chuongTrinhGiamGiaHoaDonRepository.findById(id).orElse(null));
        return "/HoaDon/ChuongTrinhGiamGiaHoaDon/edit";

    }

    //Todo Code sreach




}
