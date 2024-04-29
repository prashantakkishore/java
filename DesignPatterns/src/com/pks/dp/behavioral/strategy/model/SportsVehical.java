package com.pks.dp.behavioral.strategy.model;

import com.pks.dp.behavioral.strategy.SportsDriveStrategy;

public class SportsVehical extends Vehical{

    public SportsVehical() {
        super(new SportsDriveStrategy());
    }
}
