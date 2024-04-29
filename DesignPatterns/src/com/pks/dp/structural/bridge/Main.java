package com.pks.dp.structural.bridge;

import com.pks.dp.structural.bridge.model.Dog;
import com.pks.dp.structural.bridge.model.Fish;
import com.pks.dp.structural.bridge.model.LivingThings;

public class Main {
    public static void main(String[] args) {
        LivingThings livingThings = new Dog(new LandBreatheImplementor());
        livingThings.breatheProcess();
        LivingThings livingThings1 = new Fish(new WaterBreatheImplementor());
        livingThings1.breatheProcess();
    }
}
