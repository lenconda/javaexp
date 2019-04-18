package top.lenconda.java.homework;
import java.util.Scanner;

// convert input string to int array
class InputStringToArray {

    /**
     * @constructor
     * @param inputString
     */
    public InputStringToArray (String inputString) {
        String stringArray[] = inputString.split(" ");
        this.numberArray = new double[stringArray.length];
        for (int i = 0; i < stringArray.length; i++)
            this.numberArray[i] = Double.valueOf(stringArray[i]);
    }

    private double[] numberArray;

    public double[] convert () {
        return this.numberArray;
    }

}

class Calculator {

    public Calculator (double[] numberArray) {
        this.numbers = numberArray;
    }

    private double[] numbers;

    public double getAverage () {
        double summary = 0;
        for (int i = 0; i < this.numbers.length; i++) {
            summary += this.numbers[i];
        }
        return summary / this.numbers.length;
    }

    public double getStandardDeviation() {
        double summary = 0, squareSummary = 0;
        for (int i = 0; i < this.numbers.length; i++) {
            summary += this.numbers[i];
            squareSummary += (this.numbers[i] * this.numbers[i]);
        }
        double variance =
                Math.sqrt(
                        (squareSummary - (summary * summary / this.numbers.length)) / (this.numbers.length - 1));
        return variance;
    }

}

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter some numbers: ");
        Scanner input = new Scanner(System.in);
        String inputString = input.nextLine();
        InputStringToArray convertor = new InputStringToArray(inputString);
        double[] numberArray = convertor.convert();
        Calculator calculator = new Calculator(numberArray);
        double average = calculator.getAverage();
        double standardDeviation = calculator.getStandardDeviation();
        System.out.println("The mean is " + String.format("%.2f", average));
        System.out.println("The standard deviation is " + String.format("%.5f", standardDeviation) + "\n");
    }
}
