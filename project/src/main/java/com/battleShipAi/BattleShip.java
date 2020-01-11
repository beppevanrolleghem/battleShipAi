package com.battleShipAi;


import jdk.internal.net.http.common.Pair;

public class BattleShip {
    int[][] field;
    int[][] scoredField;
    int width;
    int height;
    int[] ships;

    public BattleShip(int width, int height, int[] ships) {
        this.width = width;
        this.height = height;
        field = new int[width][height];
        for (int[] row : field) {
            for (int cell: row) {
                cell = 0;
            }
        }
        this.ships = ships;
    }

    public Pair<Integer, Integer> pickBestMove() {
        scoreField();
        return getBestCoors();
    }

    private Pair<Integer, Integer> getBestCoors() {
        Pair<Integer, Integer> returnVal = null;
        int bestScore = 0;
        for (int xi = 0; xi < width; xi++) {
            for (int yi = 0; yi < height; yi++) {
                if (returnVal == null) {
                    returnVal = new Pair<Integer, Integer>(xi, yi);
                    bestScore = scoredField[xi][yi];
                } else {
                    if (bestScore < scoredField[xi][yi]) {
                        returnVal = new Pair<Integer, Integer>(xi, yi);
                        bestScore = scoredField[xi][yi];
                    }
                }
            }
        }
        return returnVal;
    }

    private void scoreField() {
        for (int xi = 0; xi < width; xi++) {
            for (int yi = 0; yi < height; yi++) {
                if (field[xi][yi] == 0) scoredField[xi][yi] = calculateScore(xi, yi, ships);
                if (field[xi][yi] == 1) finishHit();
                if (field[xi][yi] == -1) scoredField[xi][yi] = -1;
            }
        }
    }

    private void finishHit() {
        //todo make the values around a hit max priority
    }

    private int calculateScore(int xi, int yi, int[] ships) {
        int score = 0;
        for(int ship : ships) {
            score += Math.min(ship, xi);
            score += Math.min(ship, yi);
            score += Math.min(ship, (width-xi));
            score += Math.min(ship, (height-yi));
        }
        return score;
    }


}
