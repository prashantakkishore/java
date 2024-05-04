package com.pks.dp.behavioral.command;

public class Main {
    public static void main(String[] args) {
        // Receiver
        AirConditioner airConditioner = new AirConditioner();

        // Command
        ICommand iCommand = new TurnOnAcCommand(airConditioner);

        // Invoker
        MyRemoteControl myRemoteControl = new MyRemoteControl(iCommand);
        myRemoteControl.pressButton();

    }
}
