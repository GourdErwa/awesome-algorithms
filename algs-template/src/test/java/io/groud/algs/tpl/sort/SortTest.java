package io.groud.algs.tpl.sort;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Li.Wei by 2020/3/13
 */
class SortTest {

    private static final Integer[] INTEGER_ARRAY_DEFAULT = {8, 6, 9, 3, 5, 7, 2, 1, 4};

    private static final Sort[] IMP =
            {
                    new BubbleSort(), new InsertionSort(), new QuickSort(), new SelectSort()
                    , new MergeSort()
            };

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void sort() {
        for (Sort sort : IMP) {
            //sort.sortPrint(INTEGER_ARRAY_DEFAULT);
        }
    }

    @Test
    void sortPrint() {
    }
}