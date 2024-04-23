package com.pks.dp.structural.decorator;

public class Main {

    public static void main(String[] args) {
        BasePizza basePizza = new Mushroom(new ExtraCheese(new MargaritaPizza()));
        // Output 130 = 100 for MargaritaPizza, ExtraCheese = 20, Mushroom = 10
        System.out.println(basePizza.cost());
    }
}
