package com.pks.dp.structural.composite.calculator;

public class Number implements ArithmeticExpression {
    int value;

    public Number(int value) {
        this.value = value;
    }

    public int evaluate() {
        System.out.println("Number value is :" + value);
        return value;
    }
}
