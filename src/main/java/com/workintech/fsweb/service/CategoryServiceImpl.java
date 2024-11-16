package com.workintech.fsweb.service;

import com.workintech.fsweb.entity.Category;
import com.workintech.fsweb.exceptions.ApiException;
import com.workintech.fsweb.validation.Validations;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.workintech.fsweb.validation.ValidateCategory.checkCategoryExist;


@Service
public class CategoryServiceImpl implements CategoryService {
    private List<Category> categories = new ArrayList<>();

    @Value("${category.isprivate}")
    private Boolean isPrivate;

    @PostConstruct
    public void init() {
        categories.add(new Category(1l, "laptop"));
        categories.add(new Category(2l, "mouse"));
        categories.add(new Category(3l, "klavye"));
        if(isPrivate){
            categories.add(new Category(4l,"gaming-series"));
        }
    }

    @Override
    public List<Category> get() {
        return categories;
    }

    @Override
    public Category get(long id) {

        Validations.validate(id);
        Optional<Category> optionalCategory = categories
                .stream()
                .filter(category -> category.getId() == id)
                .findAny();

        if (optionalCategory.isEmpty()) {
            throw new ApiException("category not found with id: " + id, HttpStatus.NOT_FOUND);
        }
        return optionalCategory.get();
    }


    @Override
    public void create(Category category) {
        Validations.validate(category.getId());
        Validations.validate(category.getName());
        checkCategoryExist(categories, category, Boolean.FALSE);
        categories.add(category);

    }


    @Override
    public Category update(Category category) {

        Validations.validate(category.getId());
        Validations.validate(category.getName());
        checkCategoryExist(categories, category, Boolean.FALSE);
        Optional<Category> foundOptionalCategory = categories.stream().filter(cat -> cat.getId() == category.getId()).findAny();
        if(foundOptionalCategory.isEmpty())
            throw new ApiException("old category is not found!",HttpStatus.NOT_FOUND);

        int indexOfCategory = categories.indexOf(foundOptionalCategory.get());
        if(indexOfCategory == -1){
            throw new ApiException("Category is not found in list!",HttpStatus.NOT_FOUND);
        }
        categories.set(indexOfCategory, category);

        return category;
    }

    @Override
    public void delete(long id) {
        Validations.validate(id);
        Category category = get(id);
        checkCategoryExist(categories, category, Boolean.TRUE);
        categories.remove(category);
    }
}
