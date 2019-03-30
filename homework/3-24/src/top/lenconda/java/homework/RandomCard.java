package top.lenconda.java.homework;

class CardNumbers {
	
	private String[] numbers = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
	
	/**
	 * Get random number
	 * @param {int} minimum
	 * @param {int} maximum
	 * @return
	 */
	private int getRandomNumber (int minimum, int maximum) {
		return minimum + (int)(Math.random() * (maximum - minimum + 1));
	}
	
	/**
	 * Get random card number
	 * @return {String}
	 */
	public String random () {
		int position = this.getRandomNumber(0, 12);
		return this.numbers[position];
	}
	
}

class CardColors {
	
	private String[] colors = { "Clubs", "Diamonds", "Hearts", "Spades" };
	
	/**
	 * Get random number
	 * @param {int} minimum
	 * @param {int} maximum
	 * @return
	 */
	private int getRandomNumber (int minimum, int maximum) {
		return minimum + (int)(Math.random() * (maximum - minimum + 1));
	}
	
	/**
	 * Get random card color
	 * @return {String}
	 */
	public String random () {
		int position = this.getRandomNumber(0, 3);
		return this.colors[position];
	}
	
}

public class RandomCard {
	
	public static void main (String[] args) {
		CardNumbers cardNumbers = new CardNumbers();
		CardColors cardColors = new CardColors();
		String number = cardNumbers.random();
		String color = cardColors.random();
		System.out.println("The card you picked is " + number + " of " + color);
	}
	
}
