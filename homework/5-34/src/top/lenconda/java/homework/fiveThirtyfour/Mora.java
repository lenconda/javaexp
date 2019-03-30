package top.lenconda.java.homework.fiveThirtyfour;
import java.util.Scanner;

class MoraPlayer {

    public MoraPlayer () {
        this.score = 0;
    }

    public int score;

    public void win () {
        this.score += 1;
    }

    private int getRandomNumber (int minimum, int maximum) {
        return minimum + (int)(Math.random() * (maximum - minimum + 1));
    }

    public int play () {
        return this.getRandomNumber(0, 2);
    }

}

public class Mora {

    public static void main(String[] args) {
        MoraPlayer computer = new MoraPlayer();
        MoraPlayer human = new MoraPlayer();
        while (Math.abs(computer.score - human.score) <= 2) {
            Scanner input = new Scanner(System.in);
            System.out.println("scissor (0), rock (1), paper (2): ");
            int humanResult = input.nextInt();
            int computerResult = computer.play();
            int result = results[humanResult][computerResult];
            if (result == -1) {
                System.out.println(generateResult(computerResult, humanResult, result));
            } else if (result == 0) {
                System.out.println(generateResult(computerResult, humanResult, result));
                computer.win();
            } else if (result == 1) {
                System.out.println(generateResult(computerResult, humanResult, result));
                human.win();
            } else
                System.out.println("Something went wrong");
        }
    }

    private static String[] factors = { "scissor", "rock", "paper" };

    private static int[][] results = {
            {-1, 0, 1},
            {1, -1, 0},
            {0, 1, -1}};

    private static String generateResult (int computer, int human, int result) {
        String whoWin;
        if (result == -1)
            whoWin = " too. It is a draw";
        else if (result == 0)
            whoWin = ". Computer wins";
        else if (result == 1)
            whoWin = ". You win";
        else
            whoWin = "Something went wrong";
        return "The computer is " + factors[computer] + ". You are " + factors[human] + whoWin;
    }

}
