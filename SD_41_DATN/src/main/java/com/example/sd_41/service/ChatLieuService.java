package com.example.sd_41.service;

import com.example.sd_41.model.ChatLieu;
import com.example.sd_41.repository.ChatLieuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChatLieuService {
    @Autowired
    private ChatLieuRepository chatLieuRepository;

    public List<ChatLieu> getAll(){
        return chatLieuRepository.findAll();
    }

    public ChatLieu getone(UUID id){
        return chatLieuRepository.findById(id).orElse(null);
    }


    public void add(ChatLieu chatLieu){
        chatLieuRepository.save(chatLieu);
    }

    public void delete(UUID id){
        chatLieuRepository.deleteById(id);
    }

    public void update(UUID id,ChatLieu chatLieu){
        ChatLieu chatLieu1 = chatLieuRepository.findById(id).get();
        if(chatLieu1 != null){
            chatLieu1.setTenChatLieu(chatLieu.getTenChatLieu());
            chatLieu1.setGhiChu(chatLieu.getGhiChu());
            chatLieu1.setNgaySua(chatLieu.getNgaySua());
            chatLieu1.setNgayTao(chatLieu.getNgayTao());
            chatLieu1.setTrangThai(chatLieu.getTrangThai());
            chatLieuRepository.save(chatLieu1);
        }
    }
}
