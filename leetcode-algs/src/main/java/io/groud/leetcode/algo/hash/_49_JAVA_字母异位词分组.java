package io.groud.leetcode.algo.hash;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/group-anagrams/
 *
 * @author Li.Wei by 2020/3/7
 */
public class _49_JAVA_字母异位词分组 {

    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            if (strs.length == 0) return new ArrayList();
            Map<String, List<String>> ans = new HashMap<>();
            for (String s : strs) {
                char[] ca = s.toCharArray();
                Arrays.sort(ca);
                String key = String.valueOf(ca);
                if (!ans.containsKey(key)) ans.put(key, new ArrayList());
                ans.get(key).add(s);
            }
            return new ArrayList(ans.values());
        }
    }
}
