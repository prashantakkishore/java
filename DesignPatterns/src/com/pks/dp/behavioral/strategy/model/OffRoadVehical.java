package com.pks.dp.behavioral.strategy.model;

import com.pks.dp.behavioral.strategy.SportsDriveStrategy;

public class OffRoadVehical extends Vehical{
    public OffRoadVehical() {
        super(new SportsDriveStrategy());
    }
}
