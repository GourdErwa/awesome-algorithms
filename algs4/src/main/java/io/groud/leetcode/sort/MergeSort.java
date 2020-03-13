package io.groud.leetcode.sort;

/**
 * 归并排序
 * ———————————————————————————————————————————————————————————————————————————————
 * 总体思想：
 * ———————————————————————————————————————————————————————————————————————————————
 * 代码过程：
 * ———————————————————————————————————————————————————————————————————————————————
 * 针对有序数组优化点：
 * ———————————————————————————————————————————————————————————————————————————————
 * 属性：
 *
 * @author Li.Wei by 2020/3/13
 */
public class MergeSort implements Sort {
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        return mergeSort(array, 0, array.length - 1);
    }

    // 新建数组进行合并操作
    @SuppressWarnings("unchecked")
    private <T extends Comparable<T>> T[] mergeSort(T[] array, int left, int right) {
        // 如果二分为 1 个数时直接返回
        if (left == right) return (T[]) new Comparable[]{array[left]};

        // 划分中间值继续二分数组长度进行合并排序
        int mid = (left + right) >>> 1;
        T[] lms = mergeSort(array, left, mid);
        T[] rms = mergeSort(array, mid + 1, right);

        // 将二分排序后的数组进行合并
        int i = 0, ll = lms.length;
        int y = 0, rl = rms.length;
        int n = 0;
        Comparable<T>[] newArray = new Comparable[ll + rl];
        while (i < ll && y < rl) { // 比较最短的长度进行合并到新建数组当中
            newArray[n++] = Sorts.less(lms[i], rms[y]) ? lms[i++] : rms[y++];
        }

        // 剩余部分直接添加到新建数组当中
        while (i < ll) newArray[n++] = lms[i++];
        while (y < rl) newArray[n++] = rms[y++];

        return (T[]) newArray;
    }
}
