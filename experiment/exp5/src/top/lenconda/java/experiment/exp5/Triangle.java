package top.lenconda.java.experiment.exp5;

public class Triangle extends Polygon {

    public double a, b, c;

    public Triangle (double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getArea () {
        double p = (this.a + this.b + this.c) / 2;
        return Math.sqrt(p * (p - this.a) * (p - this.b) * (p - this.c));
    }

    @Override
    public double getPerimeter () {
        return (this.a + this.b + this.c);
    }

}
