package com.company;

import java.io.BufferedReader;

import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String string;
        try {
            string = console.readLine();
        } catch (Exception e) {
            System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            string = readString();

        }
        return string;
    }
}

