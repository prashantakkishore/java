package com.pks.dp.behavioral.state;

public class SelectionTool implements Tool{
    @Override
    public void mouseUp() {
        System.out.println("Draw dashed rectangular");
    }

    @Override
    public void mouseDown() {
        System.out.println("Selection Icon");
    }
}
