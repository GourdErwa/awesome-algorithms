package io.groud.leetcode.sort;

import static io.groud.leetcode.sort.Sorts.less;
import static io.groud.leetcode.sort.Sorts.swap;

/**
 * 选择排序
 * ———————————————————————————————————————————————————————————————————————————————
 * 总体思想：
 * - 寻找第 1 个最小值，然后找第 2 小，第 3 小...
 * 与冒泡的本质区别为：冒泡是比较替换、比较替换、比较替换，选择是比较更新临时变量、遍历结束后替换
 * ———————————————————————————————————————————————————————————————————————————————
 * 排序过程：
 * - 外层循环遍历每个元素，遍历过的元素是有序的
 * - 内层使用临时变量记录剩余元素的最小值位置，当前元素与剩余元素逐一比较，如果找到更小的值更新最小值临时变量
 * - 内层循环比对结束后最小值与当前外层循环元素交换位置
 * ———————————————————————————————————————————————————————————————————————————————
 * 针对有序数组优化点：
 * - 无，必须要逐一比较到最后位置
 * ———————————————————————————————————————————————————————————————————————————————
 * 属性：
 * - 不稳定
 * - O(1)   空间复杂度
 * - Θ(n^2)  时间复杂度
 * - Θ(n)   交换
 *
 * @author Li.Wei by 2020/3/7
 */
public class SelectSort implements Sort {

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        int length = array.length;
        int i = 0;
        while (i < length) { // 遍历每个元素
            T min = array[i]; // 当前元素最小值临时变量
            int minIndex = i; // 当前元素最小值对应数组下标

            for (int j = i + 1; j < length; j++) { // 当前元素与后续数组元素比对
                if (less(array[j], min)) { // 如果后续元素比当前元素小更新最小值记录
                    minIndex = j;
                    min = array[j];
                }
            }
            swap(array, i, minIndex); // 交换
            i++;
        }
        return array;
    }
}
