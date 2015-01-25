package com.algo.week1.inclass;

public class WeightedQuickUnionUF extends QuickUnionUF {

    private int[] sizes;

    public WeightedQuickUnionUF(int size) {
        super(size);
        sizes = new int[size];
        for (int i = 0; i < size; i++) {
            sizes[i] = 1;
        }
    }

    @Override
    protected int root(int p) {
        while (array[p] != p) {
//            array[p] = array[array[p]];
            p = array[p];
        }
        return p;
    }

    public void union(int p, int q) {
        if (!connected(p, q)) {
            int rootP = root(p);
            int rootQ = root(q);
            if (sizes[rootP] < sizes[rootQ]) {
                array[rootP] = rootQ;
                sizes[rootQ] += sizes[rootP];
            } else {
                array[rootQ] = rootP;
                sizes[rootP] += sizes[rootQ];
            }
        }
    }
}
