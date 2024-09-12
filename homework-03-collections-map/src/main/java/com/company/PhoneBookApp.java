package com.company;

import static com.company.ConstantsMap.*;

public class PhoneBookApp {
    private PhoneBook contactBook;

    public void init() {
        boolean isExit = false;
        contactBook = new PhoneBook();


        while (!isExit) {
            ConsoleHelper.writeMessage(COMMAND);
            String inputString = ConsoleHelper.readString();
            if (contactBook.checkName(inputString)) {
                if (contactBook.containsName(inputString)) {
                    System.out.println(contactBook.getContactByName(inputString));
                    break;
                } else {
                    ConsoleHelper.writeMessage(WRONG_NAME);
                    ConsoleHelper.writeMessage(COMMAND_USER_NUMBER + inputString);
                    String inputNumber = ConsoleHelper.readString();
                    if (contactBook.checkNumber(inputNumber)) {
                        contactBook.addContact(inputString, inputNumber);
                        ConsoleHelper.writeMessage(CONTACT_SAVED);
                        break;
                    }
                }
            } else if (contactBook.checkNumber(inputString)) {
                if (contactBook.containsNumber(inputString)) {
                    ConsoleHelper.writeMessage(contactBook.getContactByPhone(inputString));
                    break;
                } else {
                    ConsoleHelper.writeMessage(WRONG_NUMBER);
                    ConsoleHelper.writeMessage(COMMAND_USER_NAME + "\"" + inputString + "\"");
                    String inputName = ConsoleHelper.readString();
                    if (contactBook.checkName(inputName)) {
                        contactBook.addContact(inputName, inputString);
                        ConsoleHelper.writeMessage(CONTACT_SAVED);
                        break;
                    }
                }
            } else if (inputString.equals("LIST")) {
                for (String contact : contactBook.getAllContacts()) {
                    System.out.println(contact);
                }
                break;
            } else {
                ConsoleHelper.writeMessage(WRONG_INPUT_FORMAT);
                isExit = true;
            }
        }
    }
}
