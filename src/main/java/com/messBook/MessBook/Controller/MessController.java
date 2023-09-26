package com.messBook.MessBook.Controller;

import com.messBook.MessBook.Service.MessListService.MessListService;
import com.messBook.MessBook.Service.MessListService.Models.MessDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class MessController {
    @Autowired
    private MessListService messListService;

    @GetMapping("/messlist")
    public List<MessDTO> getMessList() {
        return messListService.messList();
    }
}
