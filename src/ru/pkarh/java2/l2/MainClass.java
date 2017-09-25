package ru.pkarh.java2.l2;

public class MainClass {

    public static void main(String[] args) {

        String[] arr = new String[3];
        arr[0] = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 0";
        arr[1] = "1 3 1 2\n2 h 2 2\n5 6 7 1\n3 3 1 0";
        arr[2] = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0";

        MyArrayUtils utils = new MyArrayUtils();

        for (int i = 0; i < arr.length; i++) {
            System.out.println("String #" + i + ":\n" + arr[i]);
            System.out.println();
            try {
                String[][] arrString = utils.splitStringToArray(arr[i]);
                System.out.println("String Array:");
                utils.printArray(arrString);
                System.out.println("Digital Array");
                int[][] arrInt = utils.convertToInteger(arrString);
                utils.printArray(arrInt);
            } catch (RuntimeException e) {
                System.out.println("Exeption: " + e.getMessage());
            }
            System.out.println();
        }
    }

}
