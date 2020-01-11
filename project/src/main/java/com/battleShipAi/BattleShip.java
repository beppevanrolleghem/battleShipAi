package com.battleShipAi;

public class BattleShip {
    int[][] field;
    int width;
    int height;


    public BattleShip(int width, int height) {
        this.width = width;
        this.height = height;
        field = new int[width][height];
        for (int[] row : field) {
            for (int cell: row) {
                cell = 0;
            }
        }
    }



}
