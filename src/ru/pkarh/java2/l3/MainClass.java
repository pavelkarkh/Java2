package ru.pkarh.java2.l3;

import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        pb.addPerson("Ivanov", new Person("+79043865439", "ivanov@mail.ru"));
        pb.addPerson("Ivanov", new Person("+79043865438", "ivanovgod@mail.ru"));
        pb.addPerson("Petrov", new Person("+79043865438", "petrov@mail.ru"));

        ArrayList<String> search = pb.getPhoneNumber("Ivanov");
        for (int i = 0; i < search.size(); i++) {
            System.out.println(search.get(i));
        }

        search = pb.getEmailNumber("Petrov");
        for (int i = 0; i < search.size(); i++) {
            System.out.println(search.get(i));
        }
    }
}
