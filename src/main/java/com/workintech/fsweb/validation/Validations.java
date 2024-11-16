package com.workintech.fsweb.validation;

import com.workintech.fsweb.entity.Category;
import com.workintech.fsweb.exceptions.ApiException;
import org.springframework.http.HttpStatus;

public class Validations {
    public  static void validate(long id) {
        if (id < 0) {
            throw new ApiException("id can not be less then zero! Given id: " + id, HttpStatus.BAD_REQUEST);
        }
    }
    public static void validate(String name) {
        if(name == null){
            throw new ApiException("name cannot be null!",HttpStatus.BAD_REQUEST);
        }
        if (name.length() < 3) {
            throw new ApiException("name should be at least 3 characters! GivenName: " + name, HttpStatus.BAD_REQUEST);
        }
    }

}
