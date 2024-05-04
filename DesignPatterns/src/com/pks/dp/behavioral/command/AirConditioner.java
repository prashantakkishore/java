package com.pks.dp.behavioral.command;

public class AirConditioner {

    boolean isOn;
    int temparature;

    public void turnOffAc(){
        System.out.println("AC turned OFF");
    }

    public void turnOnAc(){
        System.out.println("AC turned ON");
    }
    public void setAcTemprature(){
        System.out.println("AC temperature SET");
    }
}
