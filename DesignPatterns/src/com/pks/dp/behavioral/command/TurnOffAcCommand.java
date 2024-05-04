package com.pks.dp.behavioral.command;

public class TurnOffAcCommand implements ICommand {
    public TurnOffAcCommand(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    AirConditioner airConditioner;
    @Override
    public void execute() {
        airConditioner.turnOffAc();
    }

    @Override
    public void undo() {
        airConditioner.turnOnAc();
    }
}
