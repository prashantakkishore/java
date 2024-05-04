package com.pks.dp.behavioral.command;

public class TurnOnAcCommand implements ICommand{
    AirConditioner airConditioner;

    public TurnOnAcCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }
    @Override
    public void execute() {
        airConditioner.turnOnAc();
    }

    @Override
    public void undo() {
        airConditioner.turnOffAc();
    }
}
