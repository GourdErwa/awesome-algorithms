package io.groud.leetcode.algo.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/happy-number/
 * <p>
 * tag：hash、快慢指针、循环链表
 * <p>
 * 主要解决如何判断不是快乐数，即产生死循环
 *
 * @author Li.Wei by 2020/2/24
 */
public class _202_JAVA_快乐数 {

    // 哈希记录，找重复添加时不为 1 即为 false
    static class Solution {
        private final Set<Integer> dup = new HashSet<>();

        public boolean isHappy(int n) {
            int r = nextNum(n);
            return (r == 1) || (dup.add(r) && isHappy(r));
        }

        private int nextNum(int n) {
            int r = 0;
            while (n > 0) {
                int num = n % 10;
                r += (num * num);
                n /= 10;
            }
            return r;
        }
    }

    // 快慢指针
    static class Solution1 {
        public boolean isHappy(int n) {
            int slow = n;
            int fast = n;
            while (fast != 1) {
                fast = nextNum(nextNum(fast));
                slow = nextNum(slow);
                if (slow == fast) return false;
            }
            return true;
        }

        private int nextNum(int n) {
            int r = 0;
            while (n > 0) {
                int num = n % 10;
                r += (num * num);
                n /= 10;
            }
            return r;
        }
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.isHappy(19));
        System.out.println(solution.isHappy(7));
        System.out.println(solution.isHappy(17));
        System.out.println(solution.isHappy(1));
    }
}
