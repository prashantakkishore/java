package com.pks.dp.structural.bridge;

public class TreeBreatheImplementor  implements BreatheImplementor{
    @Override
    public void breathe() {
        System.out.println("I can breathe through leaves, inhale co2, release oxygen");
    }
}
