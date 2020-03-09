package io.groud.leetcode.sort;

import static io.groud.leetcode.sort.Sorts.swap;

/**
 * 快速排序
 * ———————————————————————————————————————————————————————————————————————————————
 * 总体思想：
 * 拿到一个值作为中间值，使用两个指针，一个指针指向小于中间值，一个指向大于中间值，通过两个指针向中间移动来交换数据
 * 交换数据结束后左部分的数据一定小于右部分的数据，继续分区双指针交换数据，直到分区排序的长度为 1 时排序结束
 * <p>
 * 1.
 * Flag left-> FlagValue <-right
 * 如果 left 找到一个比 FlagValue 大的值，则与 right 找到比 FlagValue 小的值交换。
 * 2.
 * Flag left-><-right
 * 碰撞后，说明寻找结束，将 Flag 与 right 交换，因为可能 left=right=FlagValue
 * 比如碰撞的值与 FlagValue 相等时  9 1 3 [left 9 right] 10 11
 * 比如碰撞的值与 FlagValue 不等时  9 1 3 [8 right]  [10 left] 11
 * 3.
 * 9 1 3 [8 right]  [10 left]
 * 剩余左右部分待排序的数据分区为 [1,8) 9 [10,11) ， 9 已经是有序的
 * ———————————————————————————————————————————————————————————————————————————————
 * 针对有序数组优化点：
 * ———————————————————————————————————————————————————————————————————————————————
 *
 * @author Li.Wei by 2020/3/9
 */
public class QuickSort implements Sort {
    @Override
    public <T extends Comparable<T>> void sort(T[] array) {
        partitionSort(array, 0, array.length - 1);
    }

    // 8 6 9
    private <T extends Comparable<T>> void partitionSort(T[] array, int lo, int hi) {
        if (lo >= hi) return;

        T flag = array[lo]; // 当前中间值
        int i = lo + 1;// 中间值左边指针
        int y = hi;// 中间值右边指针
        while (true) {
            while (array[i].compareTo(flag) < 0 && i < hi) i++; // 找大于中间值
            while (array[y].compareTo(flag) > 0 && y > lo) y--; // 找小于中间值
            if (i >= y) break; // 碰撞说明寻找结束，此时 y 的位置是中间值的位置
            swap(array, i++, y--); // 如果没有碰撞，交换数据继续寻找
        }

        swap(array, lo, y); // 将中间值放到正确 y 的位置
        partitionSort(array, lo, y); // 中间值左部分继续排序
        partitionSort(array, y + 1, hi); // 中间值右部分继续排序
    }
}
