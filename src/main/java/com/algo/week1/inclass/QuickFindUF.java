package com.algo.week1.inclass;

import java.util.Arrays;

public class QuickFindUF {

    private int[] array;

    public QuickFindUF(int size) {
        this.array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        if (p < 0 || p >= array.length || q < 0 || q >= array.length) {
            throw new IllegalArgumentException("p or q is out of bounds");
        }
        return array[p] == array[q];
    }

    public void union(int p, int q) {
        if (!connected(p, q)) {
            int tmp = array[p];
            array[p] = array[q];
            for (int i = 0; i < array.length; i++) {
                if (array[i] == tmp) {
                    array[i] = array[q];
                }
            }
        }
    }

    public void print() {
        System.out.println(Arrays.toString(array));
    }
}
