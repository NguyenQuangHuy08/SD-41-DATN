package com.example.sd_41.controller;

import com.example.sd_41.model.ChatLieu;
import com.example.sd_41.service.ChatLieuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
public class ChatLieuController {
    @Autowired
    private ChatLieuService chatLieuService;
    List<ChatLieu> chatLieuList;

    @GetMapping("/chat-lieu/hien-thi")
    private String getAll(Model model){
        List<ChatLieu> list= chatLieuService.getAll();
        model.addAttribute("chatLieu",list);
        return "ChatLieu/ChatLieu";
    }

    @GetMapping("/chat-lieu/view-update/{id}")
    public String viewUpadte(@PathVariable UUID id, Model model){
        ChatLieu chatLieu = chatLieuService.getone(id);
        model.addAttribute("cl",chatLieu);
        return "ChatLieu/viewUpadte";
    }

    @PostMapping("/chat-lieu/add")
    public String Add(@RequestParam String tenChatLieu,
                      @RequestParam String ngayTao,
                      @RequestParam String ngaySua,
                      @RequestParam String ghiChu,
                      @RequestParam String trangThai
    ){
        ChatLieu chatLieu = ChatLieu.builder()
                .ghiChu(ghiChu)
                .tenChatLieu(tenChatLieu)
                .ngayTao(ngayTao)
                .ngaySua(ngaySua)
                .trangThai(Integer.valueOf(trangThai))
                .build();
        chatLieuService.add(chatLieu);
        return "redirect:/chat-lieu/hien-thi";
    }

    @PostMapping("/chat-lieu/update/{id}")
    public String update(@RequestParam UUID id,
                         @RequestParam String tenChatLieu,
                         @RequestParam String ngayTao,
                         @RequestParam String ngaySua,
                         @RequestParam String ghiChu,
                         @RequestParam String trangThai
    ){
        ChatLieu chatLieu = ChatLieu.builder()
                .ghiChu(ghiChu)
                .tenChatLieu(tenChatLieu)
                .ngayTao(ngayTao)
                .ngaySua(ngaySua)
                .trangThai(Integer.valueOf(trangThai))
                .build();
        chatLieuService.update(id,chatLieu);
        return "redirect:/chat-lieu/hien-thi";
    }
    @GetMapping("/chat-lieu/delete/{id}")
    public String delete(@PathVariable UUID id){
        chatLieuService.delete(id);
        return "redirect:/chat-lieu/hien-thi";
    }

}
