package com.pks.dp.behavioral.command;

import java.util.Stack;

public class MyRemoteControl {
    ICommand iCommand;
    Stack<ICommand> commandHistory = new Stack<>();

    public MyRemoteControl(ICommand iCommand) {
        this.iCommand = iCommand;
    }
    public void pressButton(){
        iCommand.execute();
        commandHistory.add(iCommand);
    }

    public void undo() {
        if (!commandHistory.isEmpty()){
            ICommand command = commandHistory.pop();
            command.undo();
        }
    }
}
