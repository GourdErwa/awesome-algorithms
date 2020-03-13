package io.groud.leetcode.algo.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/
 * tag：hash
 *
 * @author Li.Wei by 2020/3/6
 */
public class _599_JAVA_两个列表的最小索引总和 {

    class Solution {
        public String[] findRestaurant(String[] list1, String[] list2) {
            int min = Integer.MAX_VALUE; // 记录索引最小值
            List<String> r = new ArrayList<>(); // 最终返回结果
            Map<String, Integer> map = new HashMap<>(); // 存放 list1<num,index>
            for (int i = 0; i < list1.length; i++) map.put(list1[i], i);

            for (int i = 0; i < list2.length; i++) { // 循环 list2 ，与 map 进行比对
                String key = list2[i];
                Integer v1 = map.get(key);
                if (v1 != null) { // 有重复元素
                    int index = v1.intValue() + i; // 计算重复元素的下标和
                    if (index > min) continue; //  如果比当前记录的最小索引大，跳出
                    if (index == min) r.add(key); // 如果相等，累加一个
                    if (index < min) {  // 如果小于当前最小值，清空集合重新添加
                        r.clear();
                        r.add(key);
                        min = index; // 更新最小值
                    }
                }
            }
            return r.toArray(new String[r.size()]);
        }
    }

    // https://leetcode-cn.com/problems/minimum-index-sum-of-two-lists/solution/liang-ge-lie-biao-de-zui-xiao-suo-yin-zong-he-by-l/
    // 官方：方法 2： 不使用哈希表 [Accepted]
    public class Solution1 {
        public String[] findRestaurant(String[] list1, String[] list2) {
            List<String> res = new ArrayList<>();
            int l1Length = list1.length;
            int l2Length = list2.length;
            int allLength = l1Length + l2Length - 1;
            for (int sum = 0; sum < allLength; sum++) {
                for (int i = 0; i <= sum; i++) {
                    if (i < l1Length && sum - i < l2Length
                            && list1[i].equals(list2[sum - i])) res.add(list1[i]);
                }
                if (!res.isEmpty()) break;
            }
            return res.toArray(new String[res.size()]);
        }
    }

}
