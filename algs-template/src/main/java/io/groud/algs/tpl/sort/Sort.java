package io.groud.algs.tpl.sort;

/**
 * 排序算法接口定义
 *
 * @author Li.Wei by 2020/3/7
 * @see BubbleSort 冒泡
 * @see InsertionSort 插入
 * @see SelectSort 选择
 * @see QuickSort 快速
 * @see MergeSortInPlace 归并-原地
 * @see MergeSortNonInPlace 归并-非原地
 */
@FunctionalInterface
public interface Sort {

    <T extends Comparable<T>> T[] sort(T[] array);

    default <T extends Comparable<T>> void sortPrint(T[] a) {
        Sorts.show(a);
        Sorts.show(sort(a));
    }

    public static void main(String[] args) {
        Sort sort = new BubbleSort();
        sort.sortPrint(new Integer[]{8, 6, 9, 3, 5, 7, 2, 1, 4});
        sort.sortPrint(new Integer[]{8, 6, 9});
    }
}
