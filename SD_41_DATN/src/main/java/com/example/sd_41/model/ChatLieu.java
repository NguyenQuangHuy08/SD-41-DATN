package com.example.sd_41.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name ="ChatLieu")
public class ChatLieu {


        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        @Column(name = "id_ChatLieu")
        private UUID id;

        @Column(name = "tenChatLieu")
        private  String tenChatLieu;

        @Column(name = "ghiChu")
        private String ghiChu;

    @Column(name = "ngayTao")
    private String ngayTao;

    @Column(name = "ngaySua")
    private String ngaySua;

    @Column(name = "trangThai")
    private int trangThai;
}
