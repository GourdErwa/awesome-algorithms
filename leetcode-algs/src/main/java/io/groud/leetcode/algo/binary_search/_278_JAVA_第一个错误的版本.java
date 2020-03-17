package io.groud.leetcode.algo.binary_search;

/**
 * https://leetcode-cn.com/problems/first-bad-version/
 *
 * @author Li.Wei by 2020/3/10
 */
public class _278_JAVA_第一个错误的版本 {

    public int firstBadVersion(int n) {
        if (!isBadVersion(n))
            return -1;

        int left = 1, right = n;
        while (left < right) { // 小于判断保证只少有二个元素
            int mid = left + ((right - left) >> 1);

            if (isBadVersion(mid))
                right = mid;// 如果为 false 继续向前
            else
                left = mid + 1;// 如果为 true 继续向后
        }
        return left;
    }

    private boolean isBadVersion(int n) {
        return n < 4;
    }

    public static void main(String[] args) {
        _278_JAVA_第一个错误的版本 o = new _278_JAVA_第一个错误的版本();
        int i = o.firstBadVersion(5);
        System.out.println(i);
    }
}
