package com.pks.dp.behavioral.state;

public class Canvas {
    private Tool toolType;

    public void mouseUp() {
        toolType.mouseUp();
    }

    public void mouseDown() {
        toolType.mouseDown();
    }
    public Tool getToolType() {
        return toolType;
    }

    public void setToolType(Tool toolType) {
        this.toolType = toolType;
    }
}
