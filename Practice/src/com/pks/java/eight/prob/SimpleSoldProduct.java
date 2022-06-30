package com.pks.java.eight.prob;

import java.math.BigDecimal;

public final class SimpleSoldProduct {

    private final String name;
    private final BigDecimal price;

    public SimpleSoldProduct(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "SimpleSoldProduct{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
