package com.hunt.otziv.services;

import com.hunt.otziv.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> categoryAll();

    void addOne(String categoryTitle);

}
