package com.pks.dp.structural.bridge.model;

import com.pks.dp.structural.bridge.BreatheImplementor;

public class Dog extends LivingThings{
    public Dog(BreatheImplementor breatheImplementor) {
        super(breatheImplementor);
    }

    @Override
    public void breatheProcess() {
        breatheImplementor.breathe();
    }
}
