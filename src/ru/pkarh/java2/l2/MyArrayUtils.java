package ru.pkarh.java2.l2;

public class MyArrayUtils {

    public String[][] splitStringToArray(String s) {
        String[][] stringArray;
        String[] rows = s.split("\n");
        stringArray = new String[rows.length][];

        for (int i = 0; i < rows.length; i++) {
            String[] cols = rows[i].split(" ");

            stringArray[i] = new String[cols.length];
            for (int j = 0; j < cols.length; j++) {
                stringArray[i][j] = cols[j];
            }
        }

        return stringArray;
    }

    public int[][] convertToInteger(String[][] strings){
        int[][] arr;
        if (strings.length != 4) {
            throw new RuntimeException("Out of bound Matrix 4x4, length rows: " + strings.length);
        } else {
            arr = new int[strings.length][];
            for (int i = 0; i < strings.length; i++) {
                if (strings[i].length != 4) {
                    throw new RuntimeException("Out of bound Matrix 4x4, length cols: " + strings[i].length + " in rows: " + i);
                } else {
                    arr[i] = new int[strings[i].length];
                    for (int j = 0; j < strings[i].length; j++) {
                        try {
                            arr[i][j] = Integer.parseInt(strings[i][j]);
                        } catch (NumberFormatException e) {
                            throw new RuntimeException("Element [" + i + ", " + j + "] not integer digit");
                        }
                    }
                }
            }
        }

        return arr;
    }

    public void printArray(String[][] s) {
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                System.out.print("[" + i +", " + j + "] = " + s[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void printArray(int[][] n) {
        for (int i = 0; i < n.length; i++) {
            for (int j = 0; j < n[i].length; j++) {
                System.out.print("[" + i +", " + j + "] = " + n[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public int halfAmount(int[][] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                result += arr[i][j];
            }
        }
        return result / 2;
    }
}
