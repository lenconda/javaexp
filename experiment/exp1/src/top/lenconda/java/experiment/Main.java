package top.lenconda.java.experiment;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        System.out.print("input a number: ");
        Scanner input = new Scanner(System.in);
        String inputResult = input.nextLine();
        String[] result = inputResult.replaceAll("^(0+)|(0+)$", "").split("\\.");
        System.out.println(result.length);
    }
}
