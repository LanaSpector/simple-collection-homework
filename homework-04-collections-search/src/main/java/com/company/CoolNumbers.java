package com.company;

import java.util.*;
import java.util.stream.IntStream;

public class CoolNumbers {
    String[] allowedChars = new String[]{"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
    List<String> listNumbers = new ArrayList<>();

    public void generateCoolNumbers() {
        for (String letter1 : allowedChars) {
            for (int i = 0; i <= 999; i = i + 111) {
                for (String letter2 : allowedChars) {
                    for (String letter3 : allowedChars) {
                        for (int j = 1; j <= 199; j++) {
                            listNumbers.add(String.format("%s%03d%s%s%03d", letter1, i, letter2, letter3, j));
                        }
                    }
                }
            }
        }
        Collections.sort(listNumbers);
    }

    public boolean bruteForceSearchInList(List<String> list, String string) {
        return false;
    }

    public boolean binarySearchInSortedList(List<String> sortedList, String string) {
        long startTime = System.nanoTime();
        int index = Collections.binarySearch(sortedList, string);
        if (index > -1) {
            System.out.printf("Бинарный поиск: номер найден, поиск занял %d нс\r", System.nanoTime() - startTime);
            return true;
        } else {
            System.out.printf("Бинарный поиск: номер не найден, поиск занял %d нс\r", System.nanoTime() - startTime);
            return false;
        }
    }

    public boolean searchInHashSet(HashSet<String> hashSet, String string) {
        return false;
    }

    public boolean searchInTreeSet(TreeSet<String> treeSet, String string) {
        return false;
    }

}
