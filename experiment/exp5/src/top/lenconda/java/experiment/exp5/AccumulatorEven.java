package top.lenconda.java.experiment.exp5;

public class AccumulatorEven extends AccumulatorBase {

    public AccumulatorEven (int maximum, int x) {
        this.maximum = maximum;
        this.x = x;
    }

    private long factorial (int number) {
        if (number <= 1)
            return 1;
        else
            return number * factorial(number - 1);
    }

    public double calculate () {
        double result = 0;
        for (int i = 1; i <= this.maximum; i++) {
            result += (this.x / this.factorial(i));
        }
        return result;
    }

}
