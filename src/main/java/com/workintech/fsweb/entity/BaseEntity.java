package com.workintech.fsweb.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class BaseEntity {
    private long id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public BaseEntity(long id) {
        this.id = id;
        this.createdAt = LocalDateTime.now();
        this.updatedAt =  LocalDateTime.now();
    }
}
