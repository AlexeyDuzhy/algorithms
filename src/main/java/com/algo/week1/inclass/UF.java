package com.algo.week1.inclass;

/**
 * Base interface for union-find data structures
 */
public interface UF {

    /**
     * Unites two elements
     *
     * @param p number to be united
     * @param q number to be united
     */
    void union(int p, int q);

    /**
     * Check whether to elements are united
     *
     * @return true is elements are united
     */
    boolean connected(int p, int q);
}
