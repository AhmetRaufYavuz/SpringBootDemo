package com.workintech.fsweb.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Price extends BaseEntity{
    private long amount;
    private Currency currency;

    public Price(long id, long amount, Currency currency) {
        super(id);
        this.amount = amount;
        this.currency = currency;
    }
}
