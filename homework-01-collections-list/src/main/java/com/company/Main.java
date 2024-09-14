package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList
        TodoList todoList = new TodoList();
        ArrayList<String> list = todoList.getTodos();
        int inputIndex = 0;
        String newString = "";
        boolean isDigit = false;
        boolean isExit = false;

        while (!isExit) {
            ConsoleHelper.writeMessage("Введите команду:");
            String inputString = ConsoleHelper.readString();
            String[] strings = inputString.split(" ");

            if (strings.length > 1 && strings[1].matches("[0-9]+")) {
                isDigit = true;
                inputIndex = Integer.parseInt(strings[1]);
                newString = String.join(" ", Arrays.copyOfRange(strings, 2, strings.length));
            }
            switch (strings[0]) {
                case "ADD":
                    if (isDigit) {
                        todoList.add(inputIndex, newString);
                    } else {
                        todoList.add(String.join(" ", Arrays.copyOfRange(strings, 1, strings.length)));
                    }
                case "LIST":
                    list.forEach(index -> ConsoleHelper.writeMessage(list.indexOf(index) + " - " + list.get(list.indexOf(index))));
                case "EDIT":
                    todoList.edit(inputIndex, newString);
                case "DELETE":
                    todoList.delete(inputIndex);
                default:
                    ConsoleHelper.writeMessage("Неверный формат ввода данных.");
                    isExit = true;
            }
        }
    }
}
