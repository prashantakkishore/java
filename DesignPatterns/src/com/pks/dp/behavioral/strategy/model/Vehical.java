package com.pks.dp.behavioral.strategy.model;

import com.pks.dp.behavioral.strategy.DriveStrategy;

public class Vehical {

    DriveStrategy driveStrategy;
    public Vehical(DriveStrategy driveStrategy) {
        this.driveStrategy = driveStrategy;
    }
    public void drive(){
        driveStrategy.drive();;
    }

}
