package ru.link.exercise06.task02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    private static final String FILENAME = "tms.txt";

    public static void main(String[] args) {
        String data = readDataFromUser();

        writeDataIntoFile(FILENAME, data);
        data = readDataFromFile(FILENAME);

        System.out.println(data.replace(' ', '_'));
    }

    /**
     * Считывает строку, введённую пользователем
     * @return Строка, введённая пользователем
     */
    private static String readDataFromUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Write line: ");
        return scanner.nextLine();
    }

    /**
     * Записывает данные в файл
     * @param filename Название файла
     * @param data Данные, записываемые в файл
     */
    private static void writeDataIntoFile(String filename, String data) {
        try {
            FileOutputStream outputStream = new FileOutputStream(filename);

            outputStream.write(data.getBytes(StandardCharsets.UTF_8));

            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Считывает данные из файла
     * @param filename Название файла
     * @return Считанные данные
     */
    private static String readDataFromFile(String filename) {
        String data = "";

        try {
            FileInputStream inputStream = new FileInputStream(filename);

            byte[] byteData = inputStream.readAllBytes();
            data = new String(byteData, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return data;
    }
}
