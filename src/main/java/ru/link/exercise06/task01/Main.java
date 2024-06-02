package ru.link.exercise06.task01;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    private static String login;
    private static String pass;
    private static String passRepeat;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            acquireData(scanner);
        } while (!SimpleSecurity.validate(login, pass, passRepeat));
    }

    private static void acquireData(Scanner scanner) {
        System.out.print("Login: ");
        login = scanner.nextLine();

        System.out.print("Password: ");
        pass = scanner.nextLine();

        System.out.print("Repeat password: ");
        passRepeat = scanner.nextLine();
    }
}
