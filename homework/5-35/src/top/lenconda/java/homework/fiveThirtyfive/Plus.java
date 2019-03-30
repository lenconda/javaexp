package top.lenconda.java.homework.fiveThirtyfive;

public class Plus {

    public static void main(String[] args) {
        double result = 0;
        for (int i = 1; i <= 624; i++) {
            result += (1 / (Math.sqrt((double)i) + Math.sqrt((double)(i + 1))));
        }
        System.out.println("The result is: " + result);
    }
}
