package io.groud.leetcode.algo.trie;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/map-sum-pairs/
 */
public class _677_JAVA_键值映射 {

    /*
    ["MapSum", "insert", "sum", "insert", "sum"]
    [[], ["aa",3], ["a"], ["aa",2], ["a"]]
     */
    class MapSum {
        private class TrieNode {
            public int sum;
            public Map<Character, TrieNode> childrenMap = new HashMap<>();
        }

        private TrieNode root = new TrieNode();
        // 使用 HashSet 存储了存在的字符串，用于添加时判断是更新还是覆盖操作。
        // 可以优化为递归调用，最后基本情况获取到是否是相同单词覆盖进行处理
        private final Set<String> has = new HashSet<>();

        public MapSum() {
        }

        public void insert(String key, int val) {
            TrieNode cur = root;
            boolean add = has.add(key);
            for (char c : key.toCharArray()) {
                TrieNode trieNode = cur.childrenMap.computeIfAbsent(c, character -> new TrieNode());
                trieNode.sum = add ? trieNode.sum + val : val;
                cur = trieNode;
            }
        }

        public int sum(String prefix) {
            TrieNode cur = root;
            for (char c : prefix.toCharArray()) {
                TrieNode trieNode = cur.childrenMap.get(c);
                if (trieNode == null) return 0;
                cur = trieNode;
            }
            return cur.sum;
        }
    }

}
