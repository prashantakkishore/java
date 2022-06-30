package com.pks.java.eight.prob;


import java.math.BigDecimal;

public final class SoldProduct {

    private final String name;
    private final BigDecimal price;
    private final String currency;

    public SoldProduct(String name, BigDecimal price, String currency) {
        this.name = name;
        this.price = price;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }
}
