package top.lenconda.java.homework;

public class Piece {

    public Piece (int column, int row) {
        this.xAxis = column;
        this.yAxis = row;
    }

    private int xAxis;
    private int yAxis;

    public int[] get () {
        int[] coordinate = new int[] {this.yAxis, this.xAxis};
        return coordinate;
    }

    public int getColumn () {
        return this.xAxis;
    }

    public int getRow () {
        return this.yAxis;
    }

}
