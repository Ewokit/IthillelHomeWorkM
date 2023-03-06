package les3hw3;

import java.util.Arrays;

public class Chess {
    public static void main(String... args) {
        String[][] chessB = new String[8][8];
        for (int i = 0; i < chessB.length; i++) {
            for (int j = 0; j < chessB[0].length; j++) {
                if ((i + j) % 2 == 0) chessB[i][j] = "W";
                else chessB[i][j] = "B";
                System.out.print(" " + chessB[i][j] + " ");
            }
            System.out.println();
        }
    }
}