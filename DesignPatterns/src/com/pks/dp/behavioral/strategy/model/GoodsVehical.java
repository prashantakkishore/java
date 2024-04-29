package com.pks.dp.behavioral.strategy.model;

import com.pks.dp.behavioral.strategy.NormalDriveStrategy;
import com.pks.dp.behavioral.strategy.SportsDriveStrategy;

public class GoodsVehical extends Vehical{

    public GoodsVehical() {
        super(new NormalDriveStrategy());
    }
}
