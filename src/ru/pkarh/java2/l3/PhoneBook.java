package ru.pkarh.java2.l3;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {

    private HashMap<String, ArrayList<Person>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void addPerson(String lastName, Person person) {
        ArrayList<Person> list = phoneBook.get(lastName);
        if (list == null) {
            list = new ArrayList<>();
            phoneBook.put(lastName, list);
        }
        phoneBook.get(lastName).add(person);
    }

    public ArrayList<String> getPhoneNumber(String lastName) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<Person> personArrayList = phoneBook.get(lastName);
        for (Person person: personArrayList) {
            result.add(person.getPhone());
        }
        return result;
    }

    public ArrayList<String> getEmailNumber(String lastName) {
        ArrayList<String> result = new ArrayList<>();
        ArrayList<Person> personArrayList = phoneBook.get(lastName);
        for (Person person: personArrayList) {
            result.add(person.getEmail());
        }
        return result;
    }
}
