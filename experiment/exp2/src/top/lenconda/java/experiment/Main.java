package top.lenconda.java.experiment;

import java.util.Scanner;

public class Main {

    public static void main (String[] args) {
        System.out.print("Input the amount: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Convert convert = new Convert(input);
        System.out.println(convert.getChineseAmount());
    }

}
