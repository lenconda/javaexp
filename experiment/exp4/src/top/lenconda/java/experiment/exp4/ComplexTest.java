package top.lenconda.java.experiment.exp4;

class Complex {

    public double real = 0;
    public double imaginary = 0;

    public Complex (double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex plus (Complex addee) {
        double adderReal = this.real;
        double adderImaginary = this.imaginary;
        double addeeReal = addee.real;
        double addeeImaginary = addee.imaginary;
        return new Complex(adderReal + addeeReal, adderImaginary + addeeImaginary);
    }

    public Complex minus (Complex minusee) {
        double minuserReal = this.real;
        double minuserImaginary = this.imaginary;
        double minuseeReal = minusee.real;
        double minuseeImaginary = minusee.imaginary;
        return new Complex(minuseeReal - minuserReal, minuseeImaginary - minuserImaginary);
    }

    public String getString () {
        String imaginaryPart = "";
        if (this.imaginary > 0)
            imaginaryPart = "+" + this.imaginary + "i";
        else if (this.imaginary < 0)
            imaginaryPart = this.imaginary + "i";
        else
            imaginaryPart = "";
        return this.real + imaginaryPart;
    }

}

public class ComplexTest {

    private static void printResult
            (String action, Complex complexer, Complex complexee, Complex newComplex) {
        String result = complexee.getString()
                + (action.equals("plus") ? " + " : " - ")
                + complexer.getString()
                + " = " + newComplex.getString();
        System.out.println(result);
    }

    public static void main (String[] args) {
        Complex test = new Complex(1, 1);
        Complex testComplex = new Complex(2, 2);
        Complex testReal = new Complex(3, 0);
        printResult("plus", test, testComplex, test.plus(testComplex));
        printResult("plus", test, testReal, test.plus(testReal));
        printResult("minus", test, testComplex, test.minus(testComplex));
        printResult("minus", test, testReal, test.minus(testReal));
    }

}
