package com.algo.week1.inclass;

import java.util.Arrays;

public class WeightedQuickUnionUF implements UF {

    private int[] array;
    private int[] sizes;

    public WeightedQuickUnionUF(int size) {
        this.array = new int[size];
        sizes = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
            sizes[i] = 1;
        }
    }

    private int root(int p) {
        while (array[p] != p) {
            array[p] = array[array[p]]; //flattens the tree
            p = array[p];
        }
        return p;
    }

    /**
     * {@inheritDoc}
     * <p>Complexity: O(lg*(n)) where lg*(n) is the following function:
     * <ul>
     * <li>lg*(1) = 0</li>
     * <li>lg*(2) = 1</li>
     * <li>lg*(4) = 2</li>
     * <li>lg*(16) = 3</li>
     * <li>lg*(65536) = 4</li>
     * <li>lg*(2^65536) = 5</li>
     * </ul>
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
     * <p>Complexity: O(lg(n))
     */
    @Override
    public void union(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);

        if (rootP != rootQ) {

            if (sizes[rootP] < sizes[rootQ]) {
                array[rootP] = rootQ;
                sizes[rootQ] += sizes[rootP];
            } else {
                array[rootQ] = rootP;
                sizes[rootP] += sizes[rootQ];
            }
        }
    }

    public void print() {
        System.out.println(Arrays.toString(array));
    }
}
