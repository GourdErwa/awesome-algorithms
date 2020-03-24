package io.groud.algs.tpl;

/**
 * 二分查找模板
 * <p>
 * 参考资料：https://www.liwei.party/2019/06/19/leetcode-solution-new/search-insert-position/
 *
 * @author Li.Wei by 2020/3/10
 */
public class BinarySearch {

    /**
     * 模板 #1 用于查找可以通过访问数组中的单个索引来确定的元素或条件。
     * <p>
     * 二分查找的最基础和最基本的形式。
     * 查找条件可以在不与元素的两侧进行比较的情况下确定（或使用它周围的特定元素）。
     * 不需要后处理，因为每一步中，你都在检查是否找到了元素。如果到达末尾，则知道未找到该元素。
     * <p>
     * 初始条件：left = 0, right = length-1
     * 终止：left > right (left = right + 1)
     * 向左查找：right = mid-1
     * 向右查找：left = mid+1
     */
    class TemplateI {
        int binarySearch(int[] nums, int target) {
            if ((nums == null) || (nums.length == 0))
                return -1;
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) >>> 1; // 计算中间点
                int midVal = nums[mid];

                if (midVal == target)
                    return mid; // 相等返回
                else if (midVal < target)
                    left = mid + 1; // 右区间继续查找
                else
                    right = mid - 1; // 左区间继续查找
            }
            return -1;
        }
    }

    /**
     * 模板 #2 是二分查找的高级模板。它用于查找需要访问数组中当前索引及其直接右邻居索引的元素或条件。
     * <p>
     * 一种实现二分查找的高级方法。
     * 查找条件需要访问元素的直接右邻居。
     * 使用元素的右邻居来确定是否满足条件，并决定是向左还是向右。
     * 保证查找空间在每一步中至少有 2 个元素。
     * 需要进行后处理。 当你剩下 1 个元素时，循环/递归结束。需要评估剩余元素是否符合条件。
     * <p>
     * 初始条件：left = 0, right = length
     * 终止：left == right
     * 向左查找：right = mid
     * 向右查找：left = mid+1
     */
    class TemplateII {
        int binarySearch(int[] nums, int target) {
            if ((nums == null) || (nums.length == 0))
                return -1;
            int left = 0, right = nums.length;
            while (left < right) { // 小于判断保证只少有二个元素
                int mid = (left + right) >>> 1; // 计算中间点
                int midVal = nums[mid];

                if (midVal == target)
                    return mid;
                else if (midVal < target)
                    left = mid + 1;
                else
                    right = mid;
            }
            // 剩余一个元素时处理
            if (left != nums.length && nums[left] == target)
                return left;
            return -1;
        }
    }

    /**
     * 模板 #3 是二分查找的另一种独特形式。 它用于搜索需要访问当前索引及其在数组中的直接左右邻居索引的元素或条件。
     * <p>
     * 实现二分查找的另一种方法。
     * 搜索条件需要访问元素的直接左右邻居。
     * 使用元素的邻居来确定它是向右还是向左。
     * 保证查找空间在每个步骤中至少有 3 个元素。
     * 需要进行后处理。 当剩下 2 个元素时，循环 / 递归结束。 需要评估其余元素是否符合条件。
     * <p>
     * 初始条件：left = 0, right = length-1
     * 终止：left + 1 == right
     * 向左查找：right = mid
     * 向右查找：left = mid
     */
    class TemplateIII {
        int binarySearch(int[] nums, int target) {
            if ((nums == null) || (nums.length == 0))
                return -1;

            int left = 0, right = nums.length - 1;
            while (left + 1 < right) {
                int mid = (left + right) >>> 1; // 计算中间点
                if (nums[mid] == target)
                    return mid;
                else if (nums[mid] < target)
                    left = mid;
                else
                    right = mid;
            }
            if (nums[left] == target)
                return left;
            if (nums[right] == target)
                return right;
            return -1;
        }
    }

    /**
     * 技巧、调试方法和注意事项
     * 1. 中间值计算
     * 这里用 (left + right) >>> 1 代替 (left + right) / 2 是非常正确的，首先是因为数组下标肯定不会是负数，另一方面如果 (left + right) 大于 int 最大值时，只有 >>>1
     * 能保证结果正确。
     *
     * 2. 计算中位数
     * 当数组的元素个数是偶数的时候：
     * 使用 mid = left + (right - left) // 2 得到左中位数的索引；
     * 使用 mid = left + (right - left + 1) // 2 得到右中位数的索引。
     *
     * 当数组的元素个数是奇数的时候直接计算即可
     */
}
