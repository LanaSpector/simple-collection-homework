package com.company;

import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private ArrayList<String> list = new ArrayList<>();

    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка
        list.add(todo);
        ConsoleHelper.writeMessage("Добавлено дело " + "\"" + todo + "\"" );
    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указанный индекс,
        //  проверьте возможность добавления
        if (index >= 0 && index <= list.size()) {
            list.add(index, todo);
            ConsoleHelper.writeMessage("Замена произведена успешно");
        }
        else {
            list.add(todo);
        }
    }

    public void edit(int index, String todo) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
        if (index >= 0 && index <= list.size()) {
            list.set(index, todo);
        }
        else {
            ConsoleHelper.writeMessage("Замена по указанному индексу невозможна");
        }

    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
        if (index >= 0 && index <= list.size()) {
            list.remove(index);
        }
        else {
            System.out.println("Дело с таким номером не существует");
        }

    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        return list;
    }

}
