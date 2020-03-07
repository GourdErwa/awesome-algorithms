package io.groud.leetcode.sort;

/**
 * 排序相关工具方法
 *
 * @author Li.Wei by 2020/3/7
 */
public class Sorts {

    /***************************************************************************
     *  Helper sorting functions.
     ***************************************************************************/

    // is min < max ?
    public static <T extends Comparable<T>> boolean less(T min, T max) {
        return min.compareTo(max) < 0;
    }

    // exchange a[i] and a[j]
    public static <T> void swap(T[] a, int i, int j) {
        if (i == j) return;
        T swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    static <T extends Comparable> boolean comSwap(T[] a, int i, int j) {
        if (a[i].compareTo(a[j]) > 0) {
            T temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            return true;
        }
        return false;
    }

    /***************************************************************************
     *  Check if array is sorted - useful for debugging.
     ***************************************************************************/

    public static <T extends Comparable<T>> boolean isSorted(T[] a) {
        return isSorted(a, 0, a.length);
    }

    // is the array a[lo..hi) sorted
    public static <T extends Comparable<T>> boolean isSorted(T[] a, int lo, int hi) {
        for (int i = lo + 1; i < hi; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    // print array to standard output
    public static <T> void show(Comparable<T>[] a) {
        System.out.println();
        for (Comparable<T> tComparable : a) System.out.print(tComparable + " ");
    }
}
