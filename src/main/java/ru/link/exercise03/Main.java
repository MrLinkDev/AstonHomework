package ru.link.exercise03;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    // Количество строк для тасков 1-3
    private static final int LINES_COUNT = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        shortestAndLongestStrings(scanner);
        stringLongerThanAvgWithLength(scanner);
        firstStringWithUniqueChars(scanner);
        stringWithDoubleChars(scanner);
    }

    /**
     * Вывод самой короткой и самой длинной строк с длинами выводимых строк
     * @param scanner Сканер
     */
    public static void shortestAndLongestStrings(Scanner scanner) {
        String data;

        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;

        String shortestString = "";
        String longestString = "";

        for (int i = 0; i < LINES_COUNT; ++i) {
            data = scanner.nextLine();

            if (data.length() < minLength) {
                minLength = data.length();
                shortestString = data;
            }

            if (data.length() > maxLength) {
                maxLength = data.length();
                longestString = data;
            }
        }

        System.out.println(shortestString + " (length = " + minLength + ")");
        System.out.println(longestString + " (length = " + maxLength + ")");
    }

    /**
     * Вывод строк, длина которых больше, чем средняя длина
     * @param scanner Сканер
     */
    public static void stringLongerThanAvgWithLength(Scanner scanner) {
        String[] data = new String[LINES_COUNT];
        float avgLength = 0;

        for (int i = 0; i < LINES_COUNT; ++i) {
            data[i] = scanner.nextLine();
            avgLength += data[i].length();
        }

        avgLength /= LINES_COUNT;

        for (int i = 0; i < LINES_COUNT; ++i) {
            if (data[i].length() > avgLength) {
                System.out.println(data[i] + " (length = " + data[i].length() + ")");
            }
        }
    }

    /**
     * Вывод первой найденной строки, символы в которой уникальны
     * @param scanner Сканер
     */
    public static void firstStringWithUniqueChars(Scanner scanner) {
        String[] data = new String[LINES_COUNT];
        HashSet<Character> symbols;
        boolean unique = true;

        for (int i = 0; i < LINES_COUNT; ++i) {
            data[i] = scanner.nextLine();
        }

        for (int i = 0; i < LINES_COUNT; ++i) {
            symbols = new HashSet<>();
            unique = true;

            for (char c : data[i].toCharArray()) {
                if (symbols.contains(c)) {
                    unique = false;
                    break;
                } else {
                    symbols.add(c);
                }
            }

            if (unique) {
                System.out.println(data[i]);
                return;
            }
        }

        System.out.println("No unique string :(");
    }

    /**
     * Вывод строки, в которой буквы продублированы
     * 65   = A;   90   = Z
     * 97   = a;   122  = z
     * 1040 = А;   1071 = Я
     * 1072 = а;   1103 = я
     * 1105 = ё;   1025 = Ё
     *
     * @param scanner Сканер
     */
    public static void stringWithDoubleChars(Scanner scanner) {
        String data = scanner.nextLine();
        StringBuilder builder = new StringBuilder();

        for (char c : data.toCharArray()) {
            builder.append(c);

            if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122) ||
                (c >= 1040 && c <= 1071) || (c >= 1072 && c <= 1103) ||
                 c == 1105 || c == 1025) {
                builder.append(c);
            }
        }

        System.out.println(builder.toString());
    }
}
