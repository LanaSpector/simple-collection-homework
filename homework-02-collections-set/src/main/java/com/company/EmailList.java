package com.company;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static com.company.ConstantsSet.*;

public class EmailList {
    Set<String> emailList = new TreeSet<>();

    public void add(String email) {
        // TODO: валидный формат email добавляется, email это строка, она быть может любой
        // TODO принять решение добавлять аргумент email или нет должен этот метод
        if (checkEmail(email)) {
                emailList.add(email.toLowerCase());
        }
        else {
            ConsoleHelper.writeMessage(WRONG_INPUT_EMAIL_FORMAT);
        }
    }

    public Set<String> getSortedEmails() {
        // TODO: возвращается сортированный список электронных адресов в алфавитном порядке
        return emailList;
    }

    public boolean checkEmail(String email) {
        return email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
    }

}
