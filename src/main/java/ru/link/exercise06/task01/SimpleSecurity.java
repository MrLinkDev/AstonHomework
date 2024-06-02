package ru.link.exercise06.task01;

import ru.link.exercise06.task01.exceptions.WrongLoginException;
import ru.link.exercise06.task01.exceptions.WrongPasswordException;

import java.util.regex.Pattern;

public final class SimpleSecurity {
    private static final int LOGIN_LENGTH = 20;
    private static final int PASSWORD_LENGTH = 20;

    private static final Pattern loginPattern = Pattern.compile("^\\S*$");
    private static final Pattern passwordPattern = Pattern.compile("^\\S*\\d{1,}\\S*$");

    /**
     * Проверяет введённые данные
     * @param login Логин
     * @param pass Пароль
     * @param passRepeat Повтор пароля
     * @return Если введённые данные соответствуют требованиям, возвращает true
     */
    public static boolean validate(String login, String pass, String passRepeat) {
        try {
            validateLogin(login);
            validatePassword(pass, passRepeat);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Wrong data");
            return false;
        }

        return true;
    }

    /**
     * Проверяет введённый логин
     * @param login Логин
     * @throws WrongLoginException
     */
    private static void validateLogin(String login) throws WrongLoginException {
        if (login.length() < LOGIN_LENGTH || !loginPattern.matcher(login).find()) {
            throw new WrongLoginException();
        }
    }

    /**
     * Проверяет введённый пароль
     * @param pass Пароль
     * @param passRepeat Повтор пароля
     * @throws WrongPasswordException
     */
    private static void validatePassword(String pass, String passRepeat) throws WrongPasswordException {
        if (pass.length() < PASSWORD_LENGTH || !passwordPattern.matcher(pass).find() || !pass.equals(passRepeat)) {
            throw new WrongPasswordException();
        }
    }
}
