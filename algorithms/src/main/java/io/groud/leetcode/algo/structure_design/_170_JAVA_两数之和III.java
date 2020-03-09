package io.groud.leetcode.algo.structure_design;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/two-sum-iii-data-structure-design/
 * <p>
 * 该题审题需注意，数字如果重复添加时，是可以重复使用的。
 *
 * @author Li.Wei by 2020/3/8
 */
public class _170_JAVA_两数之和III {

    /*
    ["TwoSum","add","add","add","find"]
    [[],[0],[-1],[1],[0]]

["TwoSum","add","add","find"]
[[],[0],[0],[0]]

["TwoSum","add","find"]
[[],[0],[0]]

["TwoSum","add","add","add","find","find"]
[[],[1],[3],[5],[4],[7]]

["TwoSum","add","add","add","find"]
[[],[0],[-1],[1],[0]]

["TwoSum","add","add","add","find","find","find","find","find"]
[[],[3],[2],[1],[2],[3],[4],[5],[6]]

["TwoSum","add","add","find","find","find","add","find","find","find","add","find"]
[[],[1],[1],[0],[1],[2],[-1],[0],[1],[-2],[-1],[-2]]
     */
    static class TwoSum {
        private final Map<Integer, Integer> map = new HashMap<>();

        public TwoSum() {
        }

        // set 记录所有数据，0 需要特殊处理
        public void add(int number) {
            map.put(number, map.containsKey(number) ? 2 : 1);
        }

        public boolean find(int value) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int key = entry.getKey();
                int diff = value - key;
                if (diff == 0) {
                    // 需要 2 个 0 , 也可能是 -1 + 1 这样
                    if (key == 0 && map.getOrDefault(0, 1) == 2) return true;
                } else {
                    if (diff == key) {
                        if (entry.getValue() == 2) return true;
                    } else {
                        if (map.containsKey(diff)) return true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();

//        twoSum.add(0);
//        System.out.println(twoSum.find(0));
//        twoSum.add(0);
//        System.out.println(twoSum.find(0));

        twoSum.add(1);
        twoSum.add(1);
        twoSum.add(1);
        System.out.println(twoSum.find(0));
        System.out.println(twoSum.find(1));
//        System.out.println(twoSum.find(2));
//        System.out.println(twoSum.find(0));
    }
}
