package io.groud.algs.tpl.sort;

import static io.groud.algs.tpl.sort.Sorts.comSwap;

/**
 * 冒泡排序
 * ———————————————————————————————————————————————————————————————————————————————
 * 总体思想：
 * 每次在 N 长度内找最大(小)的元素放到 N 的位置，比较替换
 * ———————————————————————————————————————————————————————————————————————————————
 * 排序过程：
 * - 每次比较 2 个元素，如果前一个比后一个大，交换
 * - 每次比较可以确定一个最大值，剩余比较的长度减 1
 * - 直到找到最小的元素，排序结束
 * ———————————————————————————————————————————————————————————————————————————————
 * 代码过程：
 * - 外层循环控制每次比较的剩余长度，从 N-1 开始递减，直到剩余长度为 1 时比较结束
 * - 内层循环两两比较剩余长度内元素
 * ———————————————————————————————————————————————————————————————————————————————
 * 针对有序数组优化点：
 * - 使用临时变量记录是否发生交换操作，如果一次没有发生说明剩余部分已经是有序数组，直接退出排序
 * ———————————————————————————————————————————————————————————————————————————————
 * 复杂度：
 * 外循环正好运行 N 次迭代。 但内部循环运行变得越来越短：
 * <p>
 * 当 i = 0，（N-1）次迭代（比较和可能交换）时。
 * 当 i = 1，（N-2）次迭代时，...
 * 当 i =（N-2）时，1 次迭代,
 * 当 i=（N-1），0 迭代.
 * 总迭代次数=（N-1）+（N-2）+ ... + 1 + 0 = N *（N-1）/ 2（推导）。
 * 总时间= c * N *（N-1）/ 2 = O（N ^ 2）。
 * <p>
 * 属性：
 * - 稳定
 * - O(1) 空间
 * - O(n^2) 操作替换
 * - 适应性: O(n) 时间复杂度，几乎排序时
 *
 * @author Li.Wei by 2020/3/7
 */
public class BubbleSort implements Sort {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] a) {
        int length = a.length;
        int count = 1;
        while (count < length) {
            int forLength = length - count;
            boolean needSwap = false; // 如果一次都不需要进行交换，说明本身已经有序
            for (int i = 0; i < forLength; i++) {
                needSwap = comSwap(a, i, i + 1) || needSwap; // 注意顺序，比较交换必须要先进行
            }
            if (!needSwap) {
                return a;
            }
            count++;
        }
        return a;
    }
}
