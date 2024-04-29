package com.pks.dp.behavioral.strategy;

public class SportsDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Sports drive capability");
    }
}