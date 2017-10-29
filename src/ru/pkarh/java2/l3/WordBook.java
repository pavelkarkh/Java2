package ru.pkarh.java2.l3;

import java.util.HashMap;

class WordBook {

    private HashMap<String, Integer> words;

    public WordBook(String[] array) {
        words = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            if(!words.containsKey(array[i])){
                words.put(array[i], 1);
            } else {
                int value = words.get(array[i]);
                words.put(array[i], value + 1);
            }
        }
    }

    public HashMap<String, Integer> getWords() {
        return words;
    }
}
