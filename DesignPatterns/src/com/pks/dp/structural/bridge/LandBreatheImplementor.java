package com.pks.dp.structural.bridge;

public class LandBreatheImplementor  implements BreatheImplementor{
    @Override
    public void breathe() {
        System.out.println("I can breathe through nose, Inhale oxygen, Exhale Co2");
    }
}
