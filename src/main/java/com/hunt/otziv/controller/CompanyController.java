package com.hunt.otziv.controller;

import com.hunt.otziv.dto.CompanyDto;
import com.hunt.otziv.model.Category;
import com.hunt.otziv.services.CategoryService;
import com.hunt.otziv.services.CompanyService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;
    private final CategoryService categoryService;

    public CompanyController(CompanyService companyService, CategoryService categoryService) {
        this.companyService = companyService;
        this.categoryService = categoryService;
    }

    // Метод вывода всех компаний и списка категорий.
    @GetMapping
    public String companyAll(Model model){
        model.addAttribute("company", companyService.findAll());
        model.addAttribute("category", categoryService.categoryAll());
        model.addAttribute("newCompany", new CompanyDto());
        return "company";
    }

    // Метод добавления новой компании
    @PostMapping
    public String addCompany(Model model, @ModelAttribute("newCompany") @Valid CompanyDto companyDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            model.addAttribute("category", categoryService.categoryAll());
            return "company";
        }
        System.out.println("начало работы пост метода");
        System.out.println(companyDto.isActive());

        companyService.saveCompany(companyDto);
        return "redirect:/company";
    }




}
