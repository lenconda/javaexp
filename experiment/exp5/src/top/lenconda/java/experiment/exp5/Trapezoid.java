package top.lenconda.java.experiment.exp5;

public class Trapezoid extends Polygon {

    public double a, b, c, d, height;

    public Trapezoid
            (double a, double b, double c, double d, double height) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.height = height;
    }

    @Override
    public double getArea () {
        double area = (this.a + this.c) * this.height / 2;
        return area;
    }

    @Override
    public double getPerimeter () {
        return (this.a + this.b + this.c + this.d);
    }

}
