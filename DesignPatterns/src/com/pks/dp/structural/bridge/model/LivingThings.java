package com.pks.dp.structural.bridge.model;

import com.pks.dp.structural.bridge.BreatheImplementor;

public abstract class LivingThings {
    BreatheImplementor breatheImplementor;

    public LivingThings(BreatheImplementor breatheImplementor) {
        this.breatheImplementor = breatheImplementor;
    }

    abstract public void breatheProcess();
}
