package com.example.sd_41.service;

import com.example.sd_41.model.Size;
import com.example.sd_41.model.User;
import com.example.sd_41.repository.SizeRepository;
import com.example.sd_41.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getone(UUID id){
        return userRepository.findById(id).orElse(null);
    }


    public void add(User user){
        userRepository.save(user);
    }

    public void delete(UUID id){
        userRepository.deleteById(id);
    }

    public void update(UUID id,User user){
        User user1 = userRepository.findById(id).get();
        if(user1 != null){
            user1.setEmail(user.getEmail());
            user1.setMatKhau(user.getMatKhau());
            user1.setTenUser(user.getTenUser());
            user1.setGioiTinh(user.getGioiTinh());
            user1.setNgaySinh(user.getNgaySinh());
            user1.setMaCCCD(user.getMaCCCD());
            user1.setHoKhau(user.getHoKhau());
            user1.setSoDienThoai(user.getSoDienThoai());
            user1.setDiaChi(user.getDiaChi());
            user1.setGhiChu(user.getGhiChu());
            user1.setNgayTao(user.getNgayTao());
            user1.setNgaySua(user.getNgaySua());
            user1.setTrangThai(user.getTrangThai());
            userRepository.save(user1);
        }
    }
}
