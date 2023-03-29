package com.hunt.otziv.services;

import com.hunt.otziv.model.Category;
import com.hunt.otziv.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // Вывод всех категорий с сортировкой по алфавиту.
    @Override
    public List<Category> categoryAll() {
        return categoryRepository.findAll().stream()
                .sorted((o1, o2) -> o1.getCategoryTitle().compareTo(o2.getCategoryTitle()))
                .collect(Collectors.toList());
    }

// Метод добавления новой категории в список категорий
    @Override
    public void addOne(String categoryTitle) {
        Category category = new Category();
        category.setCategoryTitle(categoryTitle);
        categoryRepository.save(category);
    }


}
