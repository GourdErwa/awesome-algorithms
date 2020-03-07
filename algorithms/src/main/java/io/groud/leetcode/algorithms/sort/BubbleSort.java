package io.groud.leetcode.algorithms.sort;

public class BubbleSort implements Sort {
    @Override
    public void sort(int[] array) {
        int length = array.length;
        int count = 1;
        while (count < length) {
            int forLength = length - count;
            for (int i = 0; i < forLength; i++) {
                caSwap(array, i, i + 1);
            }
            count++;
        }
    }
}
