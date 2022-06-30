package com.pks.oop.design.chess;

public class ComputerPlayer extends Player {

    public ComputerPlayer(boolean whiteSide) {
        this.whiteSide = whiteSide;
        this.humanPlayer = false;
    }
}
