package com.example.sd_41.controller;

import com.example.sd_41.model.Size;
import com.example.sd_41.model.User;
import com.example.sd_41.repository.SizeRepository;
import com.example.sd_41.repository.UserRepository;
import com.example.sd_41.service.SizeService;
import com.example.sd_41.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    private UserRepository userRepository;

    @GetMapping("/user/hien-thi")
    private String getAll(Model model){
        List<User> list= userService.getAll();
        model.addAttribute("user",list);
        return "User/users";
    }
    @GetMapping("/user/delete/{id}")
    public String delete(@PathVariable UUID id){
        userService.delete(id);
        return "redirect:/user/hien-thi";
    }
    @GetMapping("/user/view-update/{id}")
    public String viewUpadte(@PathVariable UUID id, Model model){
        User user = userService.getone(id);
        model.addAttribute("us",user);
        return "User/updateUser";
    }

    @PostMapping("/user/add")
    public String Add(@RequestParam String email,
                      @RequestParam String matKhau,
                      @RequestParam String tenUser,
                      @RequestParam String gioiTinh,
                      @RequestParam String ngaySinh,
                      @RequestParam String maCCCD,
                      @RequestParam String hoKhau,
                      @RequestParam String soDienThoai,
                      @RequestParam String diaChi,
                      @RequestParam String ghiChu,
                      @RequestParam String ngayTao,
                      @RequestParam String ngaySua,
                      @RequestParam String trangThai

    ){
        User user1 = User.builder()
                .email(email)
                .matKhau(matKhau)
                .tenUser(tenUser)
                .gioiTinh(gioiTinh)
                .ngaySinh(ngaySinh)
                .maCCCD(maCCCD)
                .hoKhau(hoKhau)
                .soDienThoai(soDienThoai)
                .diaChi(diaChi)
                .ghiChu(ghiChu)
                .ngayTao(ngayTao)
                .ngaySua(ngaySua)
                .trangThai(Integer.valueOf(trangThai))
                .build();
        userService.add(user1);
        return "redirect:/user/hien-thi";
    }

    @PostMapping("/user/update/{id}")
    public String update(@RequestParam UUID id,
                         @RequestParam String email,
                         @RequestParam String matKhau,
                         @RequestParam String tenUser,
                         @RequestParam String gioiTinh,
                         @RequestParam String ngaySinh,
                         @RequestParam String maCCCD,
                         @RequestParam String hoKhau,
                         @RequestParam String soDienThoai,
                         @RequestParam String diaChi,
                         @RequestParam String ghiChu,
                         @RequestParam String ngayTao,
                         @RequestParam String ngaySua,
                         @RequestParam String trangThai
    ){
        User user1 = User.builder()
                .email(email)
                .matKhau(matKhau)
                .tenUser(tenUser)
                .gioiTinh(gioiTinh)
                .ngaySinh(ngaySinh)
                .maCCCD(maCCCD)
                .hoKhau(hoKhau)
                .soDienThoai(soDienThoai)
                .diaChi(diaChi)
                .ghiChu(ghiChu)
                .ngayTao(ngayTao)
                .ngaySua(ngaySua)
                .trangThai(Integer.valueOf(trangThai))
                .build();
        userService.update(id,user1);
        return "redirect:/user/hien-thi";
    }
}
