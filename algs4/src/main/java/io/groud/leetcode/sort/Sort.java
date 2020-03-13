package io.groud.leetcode.sort;

/**
 * @author Li.Wei by 2020/3/7
 */
@FunctionalInterface
public interface Sort {

    <T extends Comparable<T>> T[] sort(T[] array);

    default <T extends Comparable<T>> void sortPrint(T[] array) {
        Sorts.show(array);
        Sorts.show(sort(array));
    }

    public static void main(String[] args) {
        Sort sort = new MergeSort();
        sort.sortPrint(new Integer[]{8, 6, 9, 3, 5, 7, 2, 1, 4});
        sort.sortPrint(new Integer[]{8, 6, 9});
    }
}
