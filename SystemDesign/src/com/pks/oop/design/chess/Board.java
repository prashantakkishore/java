package com.pks.oop.design.chess;

public class Board {
    Spot[][] boxes;

    public Board() {
        this.resetBoard();
    }

    public Spot getBox(int x, int y) throws Exception {

        if (x < 0 || x > 7 || y < 0 || y > 7) {
            throw new Exception("Index out of bound");
        }

        return boxes[x][y];
    }

    public void resetBoard() {
        // initialize white pieces
        boxes[0][0] = new Spot(0, 0, new Rooks(true));
        boxes[0][1] = new Spot(0, 1, new Knight(true));
        boxes[0][2] = new Spot(0, 2, new Bishops(true));
        //...
        boxes[1][0] = new Spot(1, 0, new Pawns(true));
        boxes[1][1] = new Spot(1, 1, new Pawns(true));
        //...

        // initialize black pieces
        boxes[7][0] = new Spot(7, 0, new Rooks(false));
        boxes[7][1] = new Spot(7, 1, new Knight(false));
        boxes[7][2] = new Spot(7, 2, new Bishops(false));
        //...
        boxes[6][0] = new Spot(6, 0, new Pawns(false));
        boxes[6][1] = new Spot(6, 1, new Pawns(false));
        //...

        // initialize remaining boxes without any piece
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                boxes[i][j] = new Spot(i, j, null);
            }
        }
    }
}
