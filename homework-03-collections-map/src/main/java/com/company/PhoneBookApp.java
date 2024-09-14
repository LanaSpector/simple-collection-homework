package com.company;

import static com.company.ConstantsMap.*;

public class PhoneBookApp {
    private PhoneBook contactBook;
    boolean isExit = false;

    public void init() {
        contactBook = new PhoneBook();
        while (!isExit) {
            ConsoleHelper.writeMessage(COMMAND);
            String inputString = ConsoleHelper.readString();
            if (contactBook.checkName(inputString)) {
                if (contactBook.containsName(inputString)) {
                    contactBook.getContactByName(inputString).forEach(ConsoleHelper::writeMessage);
                } else {
                    ConsoleHelper.writeMessage(WRONG_NAME);
                    ConsoleHelper.writeMessage(String.format(COMMAND_USER_NUMBER, inputString ));
                    String inputNumber = ConsoleHelper.readString();
                    if (contactBook.checkNumber(inputNumber)) {
                        contactBook.addContact(inputString, inputNumber);
                        ConsoleHelper.writeMessage(CONTACT_SAVED);
                    }
                    else {
                        ConsoleHelper.writeMessage(WRONG_INPUT_FORMAT);
                    }
                }
            } else if (contactBook.checkNumber(inputString)) {
                if (contactBook.containsNumber(inputString)) {
                    ConsoleHelper.writeMessage(contactBook.getContactByPhone(inputString));
                } else {
                    ConsoleHelper.writeMessage(WRONG_NUMBER);
                    ConsoleHelper.writeMessage(COMMAND_USER_NAME + "\"" + inputString + "\"");
                    String inputName = ConsoleHelper.readString();
                    if (contactBook.checkName(inputName)) {
                        contactBook.addContact(inputName, inputString);
                        ConsoleHelper.writeMessage(CONTACT_SAVED);
                    }
                    else {
                        ConsoleHelper.writeMessage(WRONG_INPUT_FORMAT);
                    }
                }
            } else if (inputString.equals("LIST")) {
                contactBook.getAllContacts().forEach(ConsoleHelper::writeMessage);
            } else {
                ConsoleHelper.writeMessage(WRONG_INPUT_FORMAT);
                isExit = true;
            }
        }
    }
}
