package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList
        TodoList todoList = new TodoList();
        ArrayList<String> list = todoList.getTodos();
        list.add("buy milk");
        list.add("make a cup of tea");
        list.add("run for life");


        while (true) {
            ConsoleHelper.writeMessage("Введите команду:");
            String inputString = ConsoleHelper.readString();
            String[] strings = inputString.split(" ");
            int inputIndex = Integer.parseInt(strings[1]);
            String[] newString = Arrays.copyOfRange(strings, 2, strings.length + 1);
            switch (strings[0]) {
                case "ADD":
                    if (strings[1].matches("[0-9]+")) {
                        todoList.add(inputIndex, String.join(" ", newString));
                        break;
                    } else {
                        todoList.add(String.join(" ", newString));
                        break;
                    }
                case "LIST":
                    list.forEach(index -> ConsoleHelper.writeMessage(list.indexOf(index) + " - " + list.get(list.indexOf(index))));
                    break;
                case "EDIT":
                    todoList.edit(inputIndex, String.join(" ", newString));
                    break;
                case "DELETE":
                    todoList.delete(inputIndex);
                    break;
                default:
                    ConsoleHelper.writeMessage("Неверный формат ввода данных.");
                    continue;
            }
        }
    }
}
