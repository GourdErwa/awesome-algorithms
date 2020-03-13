package io.groud.leetcode.algo.tpl;

/**
 * 二分查找模板
 *
 * @author Li.Wei by 2020/3/10
 */
public class BinarySearch {

    /**
     * 二分查找模板 I
     * <p>
     * 二分查找的最基础和最基本的形式。
     * 查找条件可以在不与元素的两侧进行比较的情况下确定（或使用它周围的特定元素）。
     * 不需要后处理，因为每一步中，你都在检查是否找到了元素。如果到达末尾，则知道未找到该元素。
     * <p>
     * 初始条件：left = 0, right = length-1
     * 终止：left > right
     * 向左查找：right = mid-1
     * 向右查找：left = mid+1
     */
    class TemplateI {
        int binarySearch(int[] nums, int target) {
            if ((nums == null) || (nums.length == 0)) return -1;
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1); // 计算中间点
                int midVal = nums[mid];

                if (midVal == target) return mid; // 相等返回
                else if (midVal < target) left = mid + 1; // 右区间继续查找
                else right = mid - 1; // 左区间继续查找
            }
            return -1;
        }
    }

    /**
     * 二分查找模板 II
     * <p>
     * 一种实现二分查找的高级方法。
     * 查找条件需要访问元素的直接右邻居。
     * 使用元素的右邻居来确定是否满足条件，并决定是向左还是向右。
     * 保证查找空间在每一步中至少有 2 个元素。
     * 需要进行后处理。 当你剩下 1 个元素时，循环 / 递归结束。 需要评估剩余元素是否符合条件。
     * <p>
     * 初始条件：left = 0, right = length
     * 终止：left == right
     * 向左查找：right = mid
     * 向右查找：left = mid+1
     */
    class TemplateII {
        int binarySearch(int[] nums, int target) {
            if ((nums == null) || (nums.length == 0)) return -1;
            int left = 0, right = nums.length;
            while (left < right) { // 小于判断保证只少有二个元素
                int mid = left + ((right - left) >> 1);
                int midVal = nums[mid];

                if (midVal == target) return mid;
                else if (midVal < target) left = mid + 1;
                else right = mid;
            }
            // 剩余一个元素时处理
            if (left != nums.length && nums[left] == target) return left;
            return -1;
        }
    }
}
