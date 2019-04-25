package top.lenconda.java.experiment.exp3;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.print("Input an ID card number: ");
        Scanner scanner = new Scanner(System.in);
        String inputIDCardNumber = scanner.nextLine();
        IDCard idCard = new IDCard(inputIDCardNumber);
        if (!idCard.validateLength())
            throw new Error("Not valid: length does not match");
        if (!idCard.validateCheckCode())
            throw new Error("Not valid: check code is invalid");
        if (!idCard.validateBirthDay())
            throw new Error("Not valid: birthday is invalid");
        System.out.println("Gender: " + idCard.getGender());
        System.out.println("Birthday: " + idCard.getBirthday());
        if (idCard.getIDCardVersion() == "old") {
            System.out.println("It is an old version");
            System.out.println("New version is: " + idCard.convertToNewVersion());
        }
        System.out.println("Address: " + idCard.getProvinceName() + idCard.getCityName() + idCard.getAreaName());
    }
}
