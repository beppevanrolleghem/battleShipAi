package com.battleShipAi;


import java.util.Scanner;

public class Game {
    static int width;
    static int height;
    static String[][] field;
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("How wide should the playfield be?");
        width = in.nextInt();
        System.out.println("How high should the playfield be?");
        height = in.nextInt();
        System.out.println("How many ships do you want to play with?");
        int loop = in.nextInt();
        int[] ships = new int[loop];
        field = new String[width][height];
        for (int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                field[x][y] = "O";
            }
        }

        for(int i = 0; i < loop; i++) {
            System.out.println(String.format("What do you want the size of ship %d to be?", i+1));
            ships[i] = in.nextInt();
            while(true) {
                System.out.println("\nDo you want to set the ship vertical or horizontal? (v/h)");
                String type = in.next();
                if (placeShip(in, ships[i], type.equals("h"))){
                    break;
                } else {
                    continue;
                }
            }

        }

    }







    private static boolean placeShip(Scanner in, int ship, boolean vert) {
        System.out.println("Enter the column position of the top-left of the ship");
        int col = in.nextInt()-1;
        System.out.println("Enter the row position of the top-left of the ship");
        int row = in.nextInt()-1;
        int turn = (vert) ? col : row;

        boolean success = (vert && ship + row < height) || (!vert && ship + col < width);
        for (int ij = turn; ij < turn+ship; ij++) {
            if (!vert) {
                success = !(field[ij][col].equals("S"));
                field[ij][col] = "S";
            } else {
                success = !(field[row][ij].equals("S"));
                field[row][ij] = "S";
            }
        }
        if (success) {
            System.out.println("Board currently looks like this:");
            printBoard();
            return true;
        } else {
            System.out.println("Something went wrong try again");
            return false;
        }


    }
    private static void printBoard() {
        //todo print functie die het bord toont
        //todo bord aanmaken
        String printable = "";
        for(String[] row : field) {
            for (String cell : row) {
                printable += cell + " ";
            }
            printable += "\n";
        }
        System.out.println(printable);
    }
}
