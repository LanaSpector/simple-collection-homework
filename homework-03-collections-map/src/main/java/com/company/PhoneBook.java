package com.company;

import java.util.*;

public class PhoneBook {
    private Map<String, Set<String>> contactBook;

    public PhoneBook() {
        this.contactBook = new HashMap<>();
    }

    public void addContact(String name, String phone) {
        if (checkName(name) && checkNumber(phone)) {
//            if (!contactBook.containsKey(name)) {
//                Set<String> setPhones = new HashSet<>();
//                setPhones.add(phone);
//                contactBook.put(name, setPhones);
//            } else {
//                Set<String> set = contactBook.get(name);
//                set.add(phone);
//            }
            Set<Map.Entry<String, Set<String>>> entries = contactBook.entrySet();
            for (Map.Entry<String, Set<String>> entry : new HashSet<>(entries)) {
                Set<String> values = entry.getValue();
                values.remove(phone);
                if (values.isEmpty()) {
                    contactBook.remove(entry.getKey());
                }
            }
            contactBook.putIfAbsent(name, new HashSet<>());
            contactBook.get(name).add(phone);


        }
        // TODO проверь корректность формата имени и телефона
        // TODO (рекомендуется написать отдельные методы для проверки является строка именем/телефоном)
        // TODO если такой номер уже есть в списке, то перезаписать имя абонента
    }

    /*
     new Number - new Phone
     new Number - old Phone
     old Number - new Phone
     old Number - old Phone
     */
    public Set<String> getContactByName(String name) {
        // TODO формат одного контакта "Имя - Телефон"
        // TODO если контакт не найден - вернуть пустой TreeSet
        return null;
    }

    public String getContactByPhone(String phone) {
        // TODO формат одного контакта "Имя - Телефон"
        // TODO если контакт не найдены - вернуть пустую строку
        return null;
    }

    public Set<String> getAllContacts() {
        // TODO формат одного контакта "Имя - Телефон"
        // TODO если контактов нет в телефонной книге - вернуть пустой TreeSet
        return null;
    }

    public boolean checkName(String name) {
        return name.matches("^[a-zA-Zа-яА-ЯёЁ]+$");
    }

    public boolean checkNumber(String phoneNumber) {
        return phoneNumber.matches("^7\\d{10}$");
    }
}
