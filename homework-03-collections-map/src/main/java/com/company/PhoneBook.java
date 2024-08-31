package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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


//            Set<Map.Entry<String, Set<String>>> entries = contactBook.entrySet();
//            for (Map.Entry<String, Set<String>> entry : new HashSet<>(entries)) {
//                Set<String> values = entry.getValue();
//                values.remove(phone);
//                if (values.isEmpty()) {
//                    contactBook.remove(entry.getKey());
//                }
//            }

            contactBook = contactBook.entrySet().stream()
                    .peek(entry -> entry.getValue().remove(phone))
                    .filter(entry -> !entry.getValue().isEmpty())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

            contactBook.putIfAbsent(name, new HashSet<>());
            contactBook.get(name).add(phone);
        }
    }

    public Set<String> getContactByName(String name) {
        if (!contactBook.containsKey(name)) {
            new TreeSet<>();
        }
        return Set.of(name + " - " + String.join(", ", contactBook.get(name)));
    }

    public String getContactByPhone(String phone) {
        return contactBook.entrySet().stream()
                .filter(entry -> entry.getValue().contains(phone))
                .findFirst()
                .map(entry -> entry.getKey() + " - " + String.join(", ", entry.getValue()))
                .orElse("");
    }

    public Set<String> getAllContacts() {
        if (contactBook.isEmpty()) {
            return new TreeSet<>();
        }
        return contactBook.entrySet().stream()
                .map(entry -> entry.getKey() + " - " + String.join(", ", entry.getValue()))
                .collect(Collectors.toSet());
    }

    public boolean checkName(String name) {
        return name.matches("^[a-zA-Zа-яА-ЯёЁ]+$");
    }

    public boolean checkNumber(String phoneNumber) {
        return phoneNumber.matches("^7\\d{10}$");
    }
}
