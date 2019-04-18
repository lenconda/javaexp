package top.lenconda.java.homework;
import java.util.Random;

public class PieceBoard {

    private int generateRandomNumber (int minimum, int maximum) {
        Random random = new Random();
        int randomNumber =
                random.nextInt((maximum - minimum) + 1) + minimum;
        return randomNumber;
    }

    private int[][] checkerBoard = new int[][] {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
    };

    private boolean checkRow (int row) {
        for (int i = 0; i < 8; i++) {
            if (this.checkerBoard[row][i] == 1)
                return false;
        }
        return true;
    }

    private boolean checkDiagonal (int row, int column) {
        if (row - column == 0) {
            for (int i = 0; i < 8; i++) {
                if (this.checkerBoard[i][i] == 1)
                    return false;
            }
        }
        if (row + column == 7) {
            for (int j = 0; j < 8; j++) {
                if (this.checkerBoard[j][7 - j] == 1)
                    return false;
            }
        }
        return true;
    }

    private boolean checkColumn (int column) {
        for (int k = 0; k < 8; k++) {
            if (this.checkerBoard[k][column] == 1)
                return false;
        }
        return true;
    }

    public void place () {
        for (int i = 0; i < 8; i++) {
            Piece piece = new Piece(i, this.generateRandomNumber(0, 7));
            while (
                    !this.checkRow(piece.getRow()) ||
                    !this.checkColumn(piece.getColumn()) ||
                    !this.checkDiagonal(piece.getRow(), piece.getColumn())) {
                piece = new Piece(i, this.generateRandomNumber(0, 7));
            }
            this.checkerBoard[piece.getRow()][piece.getColumn()] = 1;
        }
    }

    public int[][] get () {
        return this.checkerBoard;
    }

}
