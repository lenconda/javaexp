package top.lenconda.java.experiment.exp5;

public class Main {

    public static void main (String[] args) {
        Triangle triangle = new Triangle(6, 8, 10);
        System.out.println("Triangle area: " + triangle.getArea());
        System.out.println("Triangle perimeter: " + triangle.getPerimeter());
        Trapezoid trapezoid = new Trapezoid(4, 3,7, 5, 2);
        System.out.println("Trapezoid area: " + trapezoid.getArea());
        System.out.println("Trapezoid perimeter: " + trapezoid.getPerimeter());
        AccumulatorOdd accumulatorOdd = new AccumulatorOdd(15, 4);
        AccumulatorEven accumulatorEven = new AccumulatorEven(16, 4);
        System.out.println("Maximum = 15, x = 4: " + accumulatorOdd.calculate());
        System.out.println("Maximum = 16, x = 4: " + accumulatorEven.calculate());
    }

}
