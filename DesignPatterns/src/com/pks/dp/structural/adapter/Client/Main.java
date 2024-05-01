package com.pks.dp.structural.adapter.Client;

import com.pks.dp.structural.adapter.Adaptee.WeightMachineForBabies;
import com.pks.dp.structural.adapter.Adapter.WeightMachineAdapter;
import com.pks.dp.structural.adapter.Adapter.WeightMachineAdapterImpl;

public class Main {

    public static void main(String args[]) {

        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineForBabies());
        System.out.println(weightMachineAdapter.getWeightInKg());
    }
}
