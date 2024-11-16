package com.workintech.fsweb.service;

import com.workintech.fsweb.entity.Category;

import java.util.List;


public interface CategoryService {
    List<Category> get();
    Category get(long id);
    void create(Category category);
    Category update(Category category);
    void delete(long id);
}
