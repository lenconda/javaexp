package top.lenconda.java.experiment.exp5;

public class AccumulatorOdd extends AccumulatorBase {

    public AccumulatorOdd (int maximum, int x) {
        this.maximum = maximum;
        this.x = x;
    }

    public double calculate () {
        double result = 0;
        for (int i = 1; i <= this.maximum; i++) {
            result += (this.x / i);
        }
        return result;
    }

}
