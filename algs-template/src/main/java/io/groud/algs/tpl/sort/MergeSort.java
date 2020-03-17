package io.groud.algs.tpl.sort;

import static io.groud.algs.tpl.sort.Sorts.less;

/**
 * 归并排序 ——————————————————————————————————————————————————————————————————————————————— 总体思想： 每次将数组从中间点分为左右两部分，直到长度为 1
 * 时，开始两两合并返回
 * <p>
 * 两两合并可以使用原地算法进行合并（需要辅助数组），也可以每次合并过程中返回一个新数组（空间开销大）。
 * ——————————————————————————————————————————————————————————————————————————————— 代码过程：
 * ——————————————————————————————————————————————————————————————————————————————— 针对有序数组优化点： 无
 * ——————————————————————————————————————————————————————————————————————————————— 属性： - 稳定 - Θ(n) 数组的额外空间 - Θ(lg(n))
 * 递归使用的额外空间 - Θ(n·lg(n)) 时间复杂度 - 不自适应 - 不需要随机访问数据
 *
 * @author Li.Wei by 2020/3/13
 */
public interface MergeSort extends Sort {}

/**
 * 原地算法进行归并，每次归并仅借助一个辅助数组
 */
@SuppressWarnings("unchecked")
class MergeSortInPlace implements MergeSort {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] a) {
        mergeSort(a, (T[])new Comparable[a.length], 0, a.length - 1);
        return a;
    }

    // 原地算法进行归并合并操作
    private <T extends Comparable<T>> void mergeSort(T[] a, T[] aux, int left, int right) {
        // 如果二分为 1 个数时直接返回
        if (left >= right)
            return;

        // 划分中间值继续二分数组长度进行合并排序
        int mid = (left + right) >>> 1;
        mergeSort(a, aux, left, mid); // 左半部分排序
        mergeSort(a, aux, mid + 1, right); // 右半部分排序

        // 原地合并 [left,right] 元素

        // 将 [left,right] 元素复制到辅助数组 aux[left,right] 中
        if (right + 1 >= left)
            System.arraycopy(a, left, aux, left, right + 1 - left);

        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid)
                a[k] = aux[j++]; // 如果左边已经遍历结束，直接添加右边
            else if (j > right)
                a[k] = aux[i++]; // 如果右边已经遍历结束，直接添加左边
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++]; // 否则进行比较大小后先添加小的
            else
                a[k] = aux[i++];
        }
    }
}

/**
 * 非原地算法进行归并，每次合并需要创建新数组
 */
@SuppressWarnings("unchecked")
class MergeSortNonInPlace implements MergeSort {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] a) {
        return sort(a, 0, a.length - 1);
    }

    // 分治排序
    private <T extends Comparable<T>> T[] sort(T[] a, int left, int right) {
        // 如果二分为 1 个数时直接返回
        if (left == right)
            return (T[])new Comparable[] {a[left]};

        // 划分中间值继续二分数组长度进行合并排序
        int mid = (left + right) >>> 1;
        T[] lms = sort(a, left, mid); // 左半部分排序
        T[] rms = sort(a, mid + 1, right); // 右半部分排序
        return merge(lms, rms);
    }

    // 新建数组进行合并操作
    private <T extends Comparable<T>> T[] merge(T[] lms, T[] rms) {
        // 将二分排序后的数组进行合并
        int i = 0, ll = lms.length;
        int y = 0, rl = rms.length;
        int n = 0;
        // 新建数组用于保存最终合并结果
        Comparable<T>[] newArray = new Comparable[ll + rl];
        while (i < ll && y < rl) { // 比较最短的长度进行合并到新建数组当中
            newArray[n++] = less(lms[i], rms[y]) ? lms[i++] : rms[y++];
        }

        // 剩余部分直接添加到新建数组当中
        while (i < ll)
            newArray[n++] = lms[i++];
        while (y < rl)
            newArray[n++] = rms[y++];
        return (T[])newArray;
    }
}