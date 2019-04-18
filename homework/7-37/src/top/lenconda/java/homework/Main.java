package top.lenconda.java.homework;

import java.util.Scanner;

public class Main {

    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of balls to drop: ");
        int ballCount = input.nextInt();
        System.out.print("Enter the number of slots in the bean machine: ");
        int slotsCount = input.nextInt();
        BeanMachine beanMachine = new BeanMachine(slotsCount, ballCount);
        beanMachine.run();
        int[] result = beanMachine.get();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i]; j++)
                System.out.print("0");
            System.out.println("");
        }
    }

}
