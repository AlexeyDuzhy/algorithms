package com.algo.week1.inclass;

import java.util.Arrays;

public class QuickUnionUF implements UF {

    private int[] array;

    public QuickUnionUF(int size) {
        this.array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
    }

    private int root(int p) {
        while (array[p] != p) {
            p = array[p];
        }
        return p;
    }

    /**
     * {@inheritDoc}
     * <p>Complexity: O(n) - worst case
     */
    @Override
    public boolean connected(int p, int q) {
        if (p < 0 || p >= array.length || q < 0 || q >= array.length) {
            throw new IllegalArgumentException("p or q is out of bounds");
        }
        return root(p) == root(q);
    }

    /**
     * {@inheritDoc}
     * <p>Complexity: O(n) - worst case
     */
    @Override
    public void union(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);

        if (rootP != rootQ) {
            array[rootP] = rootQ;
        }
    }

    public void print() {
        System.out.println(Arrays.toString(array));
    }
}
