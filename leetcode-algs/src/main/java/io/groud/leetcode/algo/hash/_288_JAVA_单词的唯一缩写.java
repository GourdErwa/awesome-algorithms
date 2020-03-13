package io.groud.leetcode.algo.hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/unique-word-abbreviation/
 * <p>
 *
 * @author Li.Wei by 2020/3/8
 */
public class _288_JAVA_单词的唯一缩写 {

    /*
["ValidWordAbbr","isUnique","isUnique","isUnique","isUnique"]
[[["deer","door","cake","card"]],["dear"],["cart"],["cane"],["make"]]
     */
    // 暴力版本
    static class ValidWordAbbr {

        private final Map<String, Set<String>> hashMap = new HashMap<>();

        public ValidWordAbbr(String[] dictionary) {
            for (String s : dictionary) {
                String unique = unique(s);
                Set<String> v = hashMap.computeIfAbsent(unique, s1 -> new HashSet<>());
                v.add(s); // 缩写对应的原单词放入 Set 中
            }
        }

        public boolean isUnique(String word) {
            Set<String> v = hashMap.get(unique(word));
            // 满足条件：缩写映射为空，映射对应原单词数量 > 1，仅有一个单词是当前 word
            return v == null || (v.size() == 1 && v.contains(word));
        }

        // 单词缩写方法
        private String unique(String word) {
            int length = word.length();
            if (length < 3) return word;
            return word.charAt(0) + String.valueOf(length - 2) + word.charAt(length - 1);
        }
    }

    // 优化版本，主要优化了单缩写多映射时，map value 的处理
    class ValidWordAbbr1 {

        private final HashMap<String, String> map = new HashMap<>();

        public ValidWordAbbr1(String[] dictionary) {
            for (String s : dictionary) {
                String unique = unique(s); // 单词缩写
                String v = map.get(unique); // 单词缩写对应历史放入的单词
                if (v == null) {
                    map.put(unique, s); // 如果历史未放入，新增
                } else {
                    // 如果新放入的不是重复的，重置为 "" ，表示至少放入 2 个，永远不是唯一缩写
                    if (!v.equals(s)) map.put(unique, "");
                }
            }
        }

        public boolean isUnique(String word) {
            String v = map.get(unique(word));
            return v == null || v.equals(word);
        }

        private String unique(String word) {
            int length = word.length();
            if (length < 3) return word;
            return word.charAt(0) + String.valueOf(length - 2) + word.charAt(length - 1);
        }
    }

    public static void main(String[] args) {
        ValidWordAbbr obj = new ValidWordAbbr(new String[]{"hello", "hello"});
        System.out.println(obj.isUnique("hello"));
    }
/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
}
