package ru.pkarh.java2.l5;

import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        TestArray t = new TestArray();
        System.out.format("Time to work for single method: %.2f seconds", t.singleCalculate(t.arr));
        System.out.println();
        System.out.format("Time to work for two thread method: %.2f seconds", t.splitCalculate(t.arr2));
        System.out.println();

        if (Arrays.equals(t.arr, t.arr2)){
            System.out.println("Equals");
            //System.out.println(t.arr[0] + ", " + t.arr2[0]);
        } else {
            System.out.println("Not equals");
        }
    }
}

class TestArray{

    final int size = 10000000;
    final int h = size / 2;
    float[] arr = new float[size];
    float[] arr2 = new float[size];

    TestArray(){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
            arr2[i] = 1;
        }
    }

    float[] calculate(float[] arr, int offset){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i]
                    * Math.sin(0.2f + (i + offset) / 5)
                    * Math.cos(0.2f + (i + offset) / 5)
                    * Math.cos(0.4f + (i + offset) / 2));
        }
        return arr;
    }

    float singleCalculate(float[] arr){
        long start = System.nanoTime();
        calculate(arr, 0);
        long end = System.nanoTime();
        return (end - start) * 0.000000001f;
    }

    float splitCalculate(float[] arr){
        long start = System.nanoTime();
        float[] arrForSplit = arr;
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        System.arraycopy(arrForSplit, 0, a1, 0, h);
        System.arraycopy(arrForSplit, h, a2, 0, h);

        CalculateThread t1 = new CalculateThread("t1", a1, 0, this);
        CalculateThread t2 = new CalculateThread("t2", a2, h, this);

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(t1.arr, 0, arr, 0, h);
        System.arraycopy(t2.arr, 0, arr, h, h);

        long end = System.nanoTime();

        return (end - start) * 0.000000001f;
    }
}

class CalculateThread extends Thread {
    float[] arr;
    int offset;
    TestArray t;

    public CalculateThread(String name, float[] arr, int offset, TestArray t) {
        super(name);
        this.arr = arr;
        this.offset = offset;
        this.t = t;
        start();
    }

    @Override
    public void run() {
        arr = t.calculate(arr, offset);
    }
}
