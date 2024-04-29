package com.pks.dp.structural.bridge.model;

import com.pks.dp.structural.bridge.BreatheImplementor;

public class Fish extends LivingThings{
    public Fish(BreatheImplementor breatheImplementor) {
        super(breatheImplementor);
    }

    @Override
    public void breatheProcess() {
        breatheImplementor.breathe();
    }
}
