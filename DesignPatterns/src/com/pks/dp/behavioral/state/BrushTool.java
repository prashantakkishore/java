package com.pks.dp.behavioral.state;

public class BrushTool implements Tool{
    @Override
    public void mouseUp() {
        System.out.println("Draw line");
    }

    @Override
    public void mouseDown() {
        System.out.println("Brush Icon");
    }
}
