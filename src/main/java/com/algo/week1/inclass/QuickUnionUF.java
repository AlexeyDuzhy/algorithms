package com.algo.week1.inclass;

import java.util.Arrays;

public class QuickUnionUF {

    protected int[] array;

    public QuickUnionUF(int size) {
        this.array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
    }

    protected int root(int p) {
        while (array[p] != p) {
            p = array[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        if (p < 0 || p >= array.length || q < 0 || q >= array.length) {
            throw new IllegalArgumentException("p or q is out of bounds");
        }
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        if (!connected(p, q)) {
            array[root(p)] = root(q);
        }
    }

    public void print() {
        System.out.println(Arrays.toString(array));
    }
}
