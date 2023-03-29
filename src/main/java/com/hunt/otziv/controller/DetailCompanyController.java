package com.hunt.otziv.controller;

import com.hunt.otziv.dto.CompanyDto;
import com.hunt.otziv.services.CategoryService;
import com.hunt.otziv.services.CompanyService;
import com.hunt.otziv.services.ReviewService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/detailCompany")
public class DetailCompanyController {

    private final CompanyService companyService;
    private final CategoryService categoryService;
    private final ReviewService reviewService;


    public DetailCompanyController(CompanyService companyService, CategoryService categoryService, ReviewService reviewService) {
        this.companyService = companyService;
        this.categoryService = categoryService;
        this.reviewService = reviewService;
    }

    // Вывод страницы конкретной фирмы с ее отзывами
    @GetMapping("/{id}")
    public String detailCompany(@PathVariable("id") long id, Model model){
        model.addAttribute("reviews", reviewService.findAllByCompanyId(id));
        return "detail";
    }

    // Вывод страницы и формы редактирования компаний
    @GetMapping("/{id}/edit")
    public String editCompany(@PathVariable("id") long id, Model model){
        model.addAttribute("companys", companyService.findById(id));
        model.addAttribute("category", categoryService.categoryAll());
        return "company-edit";
    }

    // Метод сохранения отредактированных данных компании
    @PostMapping("/{id}/edit")
    public String addCompany(Model model, @ModelAttribute("companys") @Valid CompanyDto companyDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            model.addAttribute("category", categoryService.categoryAll());
            return "company-edit";
        }
        System.out.println("пост запрос изменение");
        companyService.editCompany(companyDto);
        System.out.println(companyDto.getId());
        System.out.println(companyDto.getCategorys().getId());

        return "redirect:/company";
    }

    // Метод удаления копании
    @GetMapping("/{id}/delete")
    public String deleteCompany(@PathVariable("id") long id, Model model){
        return "detail";
    }
}
