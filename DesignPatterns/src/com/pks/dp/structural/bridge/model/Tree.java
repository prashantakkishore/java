package com.pks.dp.structural.bridge.model;

import com.pks.dp.structural.bridge.BreatheImplementor;

public class Tree extends LivingThings{
    public Tree(BreatheImplementor breatheImplementor) {
        super(breatheImplementor);
    }

    @Override
    public void breatheProcess() {
        breatheImplementor.breathe();
    }
}
