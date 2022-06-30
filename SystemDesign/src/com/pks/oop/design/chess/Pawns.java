package com.pks.oop.design.chess;

public class Pawns extends Piece {
    public Pawns(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Spot start, Spot end) {
        return false;
    }

    @Override
    public boolean isCastlingMove() {
        return false;
    }
}
