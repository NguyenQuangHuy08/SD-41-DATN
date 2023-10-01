package com.example.sd_41.service.HoaDon.ChuongTrinhGiamGiaHoaDon;

import com.example.sd_41.model.ChuongTrinhGiamGiaHoaDon;
import com.example.sd_41.repository.HoaDon.ChuongTrinhGiamGia.ChuongTrinhGiamGiaHoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ChuongTrinhGiamGiaHoaDonService {

        @Autowired
        private ChuongTrinhGiamGiaHoaDonRepository chuongTrinhGiamGiaHoaDonRepository;

        //Tìm kiếm all

        public List<ChuongTrinhGiamGiaHoaDon> findChuongTrinhGiamGiaHoaDon(String tenChuongTrinh, String soLuongSanPham, String phanTramGiam, BigDecimal soTienHoaDon) {
            if (tenChuongTrinh != null && soLuongSanPham != null
                                && phanTramGiam !=null && soTienHoaDon != null) {

              return chuongTrinhGiamGiaHoaDonRepository.findChuongTrinhGiamGiaHoaDonByTenChuongTrinhAndSoTienHoaDonAndPhanTramGiamAndSoLuongSanPham(tenChuongTrinh, soTienHoaDon , phanTramGiam, soLuongSanPham);

            } else if (tenChuongTrinh != null) {

                return chuongTrinhGiamGiaHoaDonRepository.findChuongTrinhGiamGiaHoaDonByTenChuongTrinh(tenChuongTrinh);

            } else if (soTienHoaDon != null) {

                return chuongTrinhGiamGiaHoaDonRepository.findChuongTrinhGiamGiaHoaDonBySoTienHoaDon(soTienHoaDon);

            } else if(phanTramGiam != null){

                return chuongTrinhGiamGiaHoaDonRepository.findChuongTrinhGiamGiaHoaDonByPhanTramGiam(phanTramGiam);

            }else if(soLuongSanPham !=null){

                return chuongTrinhGiamGiaHoaDonRepository.findChuongTrinhGiamGiaHoaDonBySoLuongSanPham(soLuongSanPham);

            } else{
                // Trường hợp không có tham số được cung cấp, bạn có thể trả về toàn bộ danh sách sản phẩm
                return chuongTrinhGiamGiaHoaDonRepository.findAll();
            }
        }


//        public List<ChuongTrinhGiamGiaHoaDon> findChuongTrinhGiamGiaHoaDonBySoLuongSanPham(int soLuongSanPham){
//
//            return chuongTrinhGiamGiaHoaDonRepository.findChuongTrinhGiamGiaHoaDonBySoLuongSanPham(soLuongSanPham);
//
//        }


}

