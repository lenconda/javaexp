package top.lenconda.java.homework;

public class Main {

    public static void main (String[] args) {
        PieceBoard pieceBoard = new PieceBoard();
        pieceBoard.place();
        int[][] currentCheckerBoard = pieceBoard.get();
        for (int i = 0; i < 8; i++) {
            System.out.print("|");
            for (int j = 0; j < 8; j++) {
                System.out.print(currentCheckerBoard[i][j] == 1 ? "Q" : " ");
                System.out.print("|");
            }
            System.out.println("");
        }
    }

}
