package top.lenconda.java.homework;

import java.util.Random;

public class BeanMachine {

    private int slotsCount;
    private int ballCount;
    private int[][] routes;
    private int[] slots;

    public BeanMachine(int slotsNumber, int ballsNumber) {
        slotsCount = slotsNumber;
        ballCount = ballsNumber;
        slots = new int[slotsNumber];
        routes = new int[ballsNumber][slotsNumber];
        for (int i = 0; i < slotsNumber; i++)
            slots[i] = 0;
    }

    private int generateRandomNumber (int minimum, int maximum) {
        Random random = new Random();
        int randomNumber =
                random.nextInt((maximum - minimum) + 1) + minimum;
        return randomNumber;
    }

    // 0 is left, 1 is right
    private int[] generateRoute () {
        int[] routeArray = new int[this.slotsCount - 1];
        for (int i = 0; i < this.slotsCount - 1; i++)
            routeArray[i] = generateRandomNumber(0, 1);
        return routeArray;
    }

    private int runOneBall (int[] inputRoutes) {
        int slotPosition = 0;
        for (int i = 0; i < inputRoutes.length; i++) {
            slotPosition += inputRoutes[i];
        }
        return slotPosition;
    }

    public void run () {
        for (int i = 0; i < this.ballCount; i++) {
            int[] routes = this.generateRoute();
            this.routes[i] = routes;
            int position = this.runOneBall(routes);
            this.slots[position] = this.slots[position] + 1;
        }
    }

    public int[] get () {
        return this.slots;
    }

}
