package com.workintech.fsweb.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseEntity {

    private String name;
    private Price price;

    public Product(long id, String name, Price price) {
        super(id);
        this.name = name;
        this.price = price;
    }
}
