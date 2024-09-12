package set;

import map.ConsoleHelper;

public class Main implements ConstantsSet {
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
        list.add("sweden@mail.ru");
        list.add("345-irurj@mail.com");
        list.add("Zubr@mail.fgrt");
        list.add("lung-lung@gmail.ru");
        list.add("q@g.ru");
        list.add("ifgftUj@fd.ru");
        list.add("we@q.ytu");

        System.out.println(list.getSortedEmails());


        while (true) {
            ConsoleHelper.writeMessage(COMMAND);
            String inputString = ConsoleHelper.readString();
            if (inputString.startsWith("ADD")) {
                String[] strings = inputString.split(" ");
                if (list.checkEmail(strings[1])) {
                    list.add(strings[1]);
                    ConsoleHelper.writeMessage(EMAIL_SAVED);
                    break;
                } else {
                    ConsoleHelper.writeMessage(WRONG_INPUT_EMAIL_FORMAT);
                    continue;
                }
            } else if (inputString.equals("LIST")) {
                for (String email : list.getSortedEmails()) {
                    ConsoleHelper.writeMessage(email);
                }
                break;
            }
        }
    }
}
