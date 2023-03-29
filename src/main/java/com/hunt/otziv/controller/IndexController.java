package com.hunt.otziv.controller;

import com.hunt.otziv.dto.CompanyDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController  {

    // Открытие стартовой страницы
    @GetMapping
    public String companyAll(Model model){
        return "index";
    }
}
