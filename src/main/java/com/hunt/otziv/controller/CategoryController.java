package com.hunt.otziv.controller;

import com.hunt.otziv.services.CategoryService;
import com.hunt.otziv.services.CompanyService;
import com.hunt.otziv.services.ReviewService;
import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {

    private final CompanyService companyService;
    private final CategoryService categoryService;

    private final ReviewService reviewService;

    public CategoryController(CompanyService companyService, CategoryService categoryService, ReviewService reviewService) {
        this.companyService = companyService;
        this.categoryService = categoryService;
        this.reviewService = reviewService;
    }



    /*Основной метод загружающий список категорий*/
    @GetMapping
    public String companyAll(Model model){
        model.addAttribute("categorys", categoryService.categoryAll());
//        model.addAttribute("reviews", reviewService.findAll());
        return "category";
    }
    /*Пост метод, который по выбору категории, возвращает все отзывы относящиеся к выбранной категории*/
    @PostMapping()
    public String companyAllId( @Valid Long id, Model model){
        System.out.println(id);
        model.addAttribute("categorys", categoryService.categoryAll());
        model.addAttribute("reviews", reviewService.findAllByCategoryId(id));
        return "category";
    }



    /*Загрузка страницы добавления новой категории*/
    @GetMapping ("/add")
    public String categoryAdd( Model model){

        return "category_add";
    }
    /*Пост метод добавления новой категории в базу категорий*/

    @PostMapping ("/add")
    public String categoryAddPost(@RequestParam("new_category") String categoryTitle, Model model){
        System.out.println(categoryTitle);
        categoryService.addOne(categoryTitle);
        return "redirect:/category/add";
    }
}
