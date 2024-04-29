package com.pks.dp.behavioral.strategy;

import com.pks.dp.behavioral.strategy.model.GoodsVehical;
import com.pks.dp.behavioral.strategy.model.SportsVehical;
import com.pks.dp.behavioral.strategy.model.Vehical;

public class Main {
    public static void main(String[] args) {
        Vehical vehical = new GoodsVehical();
        vehical.drive();
        Vehical vehical2 = new SportsVehical();
        vehical2.drive();

    }
}
