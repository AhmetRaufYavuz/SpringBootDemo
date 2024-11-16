package com.workintech.fsweb.validation;

import com.workintech.fsweb.entity.Category;
import com.workintech.fsweb.exceptions.ApiException;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

public class ValidateCategory {
    public static void checkCategoryExist(List<Category> categories, Category category, boolean shouldExist) {
        if (shouldExist) {
            categories
                    .stream()
                    .filter(cat -> cat.getName().equalsIgnoreCase(category.getName()))
                    .findAny()
                    .orElseThrow(() -> new ApiException("category is not exist: " + category.getName(), HttpStatus.NOT_FOUND));
        } else {
            boolean exist = categories
                    .stream()
                    .anyMatch(cat -> cat.getName().equalsIgnoreCase(category.getName()));
            if (exist) {
                throw new ApiException("category with given name already exist! Given Name: " + category.getName(), HttpStatus.BAD_REQUEST);
            }


        }

    }
}
