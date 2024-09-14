package com.company;


import static com.company.ConstantsSet.*;

public class Main {
     /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */

    public static void main(String[] args) {
        //TODO: write code here
        EmailList list = new EmailList();
        boolean isExit = false;

        while (!isExit) {
            ConsoleHelper.writeMessage(COMMAND);
            String inputString = ConsoleHelper.readString();
            if (inputString.startsWith("ADD")) {
                String[] strings = inputString.split(" ");
                if (list.checkEmail(strings[1])) {
                    list.add(strings[1]);
                    ConsoleHelper.writeMessage(EMAIL_SAVED);
                } else {
                    ConsoleHelper.writeMessage(WRONG_INPUT_EMAIL_FORMAT);
                }
            } else if (inputString.equals("LIST")) {
                list.getSortedEmails().forEach(ConsoleHelper::writeMessage);
                isExit = true;
            }
        }
    }
}
