package com.battleShipAi;


import java.util.Scanner;

public class Game {
    //todo vars aanmaken voor bijhouden speler stats.

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("How wide should the playfield be?");
        int width = in.nextInt();
        System.out.println("How high should the playfield be?");
        int height = in.nextInt();
        System.out.println("How many ships do you want to play with?");
        int loop = in.nextInt();
        int[] ships = new int[loop];
        String[][] field = new String[width][height];
        for(String[] row : field) {
            for (String cel: row) {
                cell = "O";
            }
        }
        for(int i = 0; i < loop; i++) {
            System.out.println(String.format("What do you want the size of ship %d to be?", i+1));
            ships[i] = in.nextInt();
            while(true) {
                System.out.println("\nDo you want to set the ship vertical or horizontal? (v/h)");
                String type = in.next();
                if (type.equals("v")){
                    System.out.println("Enter the column position of the top of the ship");
                    int col = in.nextInt();
                    System.out.println("Enter the row position of the top of the ship");
                    int row = in.nextInt();
                    boolean success = true;
                    try {
                        for (int ij = row; ij < ships[i]; ij++) {
                            if (field[col][ij].equals("S")) {
                                success = false;
                                break;
                            } else {
                                field[col][ij] = "S";
                            }
                        }
                    } catch (Exception e) {
                        success = false;
                    }
                    if (success){
                       System.out.println("Board currently looks like this:")
                       printBoard();
                       break;
                    }
                } else if (type.equals("h")) {
                   //todo refactor top part so we can reuse it here.
                }



                System.out.println(String.format("What do you want the tail position of the ship to be? \nX:"));
                int xpos1 = in.nextInt();
                System.out.println(String.format("Y:"));
                int ypos1 = in.nextInt();


                System.out.println("Something was invalid, try again.\nFor ship with width " + ships[i]);
                if (xpos > width || xpos < 0 || ypos > height || ypos < 0) System.out.println("Positions invalid, try again. \n");
                else {

                }
            }

        }
        for(int i = 0; i < loop; i++) {

        }





        BattleShip opponent = new BattleShip()
    }

    private static void printBoard() {
        //todo print functie die het bord toont
        //todo bord aanmaken
    }
}
