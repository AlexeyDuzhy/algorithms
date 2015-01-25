package com.algo.week1.inclass;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class UFTest {

    /**
     * After performing union should have following groups
     * {0, 1, 5} {2, 4, 6, 7, 8} {3, 9}
     */
    @Test
    public void testQuickFindUF() {
        UF quickFindUF = new QuickFindUF(10);

        quickFindUF.union(0, 1);
        quickFindUF.union(1, 5);

        quickFindUF.union(2, 6);
        quickFindUF.union(2, 4);
        quickFindUF.union(4, 6);
        quickFindUF.union(7, 6);
        quickFindUF.union(6, 8);

        quickFindUF.union(3, 9);

        assertThat(true, is(quickFindUF.connected(0, 5)));
        assertThat(true, is(quickFindUF.connected(2, 8)));
        assertThat(true, is(quickFindUF.connected(3, 9)));
        assertThat(false, is(quickFindUF.connected(1, 2)));
    }

    @Test
    public void testQuickUnionUF() {
        UF quickFindUF = new QuickUnionUF(10);

        quickFindUF.union(0, 1);
        quickFindUF.union(1, 5);

        quickFindUF.union(2, 6);
        quickFindUF.union(2, 4);
        quickFindUF.union(4, 6);
        quickFindUF.union(7, 6);
        quickFindUF.union(6, 8);

        quickFindUF.union(3, 9);

        assertThat(true, is(quickFindUF.connected(0, 5)));
        assertThat(true, is(quickFindUF.connected(2, 8)));
        assertThat(true, is(quickFindUF.connected(3, 9)));
        assertThat(false, is(quickFindUF.connected(1, 2)));
    }

    @Test
    public void testWeightedQuickUnionUF() {
        UF quickFindUF = new WeightedQuickUnionUF(10);

        quickFindUF.union(0, 1);
        quickFindUF.union(1, 5);

        quickFindUF.union(2, 6);
        quickFindUF.union(2, 4);
        quickFindUF.union(4, 6);
        quickFindUF.union(7, 6);
        quickFindUF.union(6, 8);

        quickFindUF.union(3, 9);

        assertThat(true, is(quickFindUF.connected(0, 5)));
        assertThat(true, is(quickFindUF.connected(2, 8)));
        assertThat(true, is(quickFindUF.connected(3, 9)));
        assertThat(false, is(quickFindUF.connected(1, 2)));
    }
}