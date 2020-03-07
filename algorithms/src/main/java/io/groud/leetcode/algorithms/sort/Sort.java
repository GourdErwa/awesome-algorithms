package io.groud.leetcode.algorithms.sort;

import java.util.Arrays;

public interface Sort {

    void sort(int[] array);

    default void sortPrint(int[] array) {
        print(array);
        sort(array);
        print(array);
    }

    default void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    default void swap(int[] array, int i, int y) {
        int temp = array[i];
        array[i] = array[y];
        array[y] = temp;
    }

    default void caSwap(int[] array, int i, int y) {
        if (array[i] > array[y]) {
            int temp = array[i];
            array[i] = array[y];
            array[y] = temp;
        }
    }

    public static void main(String[] args) {
        Sort sort = new BubbleSort();
        sort.sortPrint(new int[]{8, 6, 9, 3, 5, 7, 2, 1, 4});
    }
}
