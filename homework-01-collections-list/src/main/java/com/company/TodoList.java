package com.company;

import java.util.ArrayList;

public class TodoList {
    private ArrayList<String> list = new ArrayList<>();

    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка
        list.add(todo);
        ConsoleHelper.writeMessage(String.format("Добавлено дело \"%s\"", todo));

    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указанный индекс,
        //  проверьте возможность добавления
        if (index >= 0 && index <= list.size()) {
            list.add(index, todo);
            ConsoleHelper.writeMessage(String.format("В позицию %d добавлено дело \"%s\"", index, todo));
        } else {
            list.add(todo);
        }
    }

    public void edit(int index, String todo) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
        if (index >= 0 && index <= list.size()) {
            String newToDo = list.set(index, todo);
            ConsoleHelper.writeMessage(String.format("Дело \"%s\" заменено на \"%s\"", todo, newToDo));
        } else {
            ConsoleHelper.writeMessage("Замена по указанному индексу невозможна");
        }

    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
        if (index >= 0 && index < list.size()) {
            String removed = list.remove(index);
            ConsoleHelper.writeMessage(String.format("Дело \"%s\" удалено", removed));
        } else {
            System.out.println("Дело с таким номером не существует");
        }

    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        return list;
    }

}
