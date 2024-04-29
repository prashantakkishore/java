package com.pks.dp.structural.bridge;

public class WaterBreatheImplementor implements BreatheImplementor{
    @Override
    public void breathe() {
        System.out.println("I can breathe through gills, absorb oxygen from water, release Co2");
    }
}
