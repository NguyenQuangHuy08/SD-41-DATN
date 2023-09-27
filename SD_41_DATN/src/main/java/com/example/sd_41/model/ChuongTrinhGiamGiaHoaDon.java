package com.example.sd_41.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "ChuongTrinhGiamGiaHoaDon")
public class ChuongTrinhGiamGiaHoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id_ChuongTrinhGiamGiaHoaDon")
    private UUID Id_ChuongTrinhGiamGiaHoaDon;

    @Column(name = "tenChuongTrinh")
    private String tenChuongTrinh;

    @Column(name = "phanTramGiam")
    private int phanTramGiam;

    @Column(name = "soLuongSanPham")
    private int soLuongSanPham;

    @Column(name = "soTienHoaDon")
    private BigDecimal soTienHoaDon;

    @Column(name = "ngayBatDau")
    private String ngayBatDau;

    @Column(name = "ngayKetThuc")
    private String ngayKetThuc;

    @Column(name = "ghiChu")
    private String ghiChu;

    @Column(name = "ngayTao")
    private String ngayTao;

    @Column(name = "ngaySua")
    private String ngaySua;

    @Column(name = "trangThai")
    private int trangThai;

}
