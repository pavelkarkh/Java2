package ru.pkarh.java2.l3;

import java.util.HashMap;
import java.util.Map;

public class Words {
    public static void main(String[] args) {
        String[] words = {"one", "two", "two", "three", "three", "three", "four", "four", "four", "four",
        "five", "five", "five", "five", "five", "six", "six", "six", "six", "six", "six"};

        WordBook wordBook = new WordBook(words);
        HashMap<String, Integer> mapBook = wordBook.getWords();

        for (Map.Entry entry: mapBook.entrySet()) {
            System.out.println("Word: " + entry.getKey() + ", count: " + entry.getValue());
        }
    }
}
