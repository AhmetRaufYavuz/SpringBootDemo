package com.workintech.fsweb.entity;

import lombok.*;


@Getter
@Setter
public class Category extends BaseEntity {

    private String name;

    public Category(long id, String name) {
        super(id);
        this.name = name;
    }
}
