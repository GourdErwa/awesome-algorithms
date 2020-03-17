package io.groud.leetcode.algo.bit_operation;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/single-number-iii/
 * <p>
 * tag：位运算、hash
 * <p>
 * 解法： 1. 位运算 TODO 位运算未完成 3. 放入 HasSet ，出现 2 次重复移除
 *
 * @author Li.Wei by 2020/2/24
 */
public class _260_JAVA_只出现一次的数字III {

    // 放入 set ，出现重复移除，剩余为出现一次数字
    class Solution {
        public int[] singleNumber(int[] nums) {
            Set<Integer> dup = new HashSet<>();
            for (int num : nums)
                if (!dup.add(num))
                    dup.remove(num);
            Iterator<Integer> iterator = dup.iterator();
            return new int[] {iterator.next(), iterator.next()};
        }
    }
}
