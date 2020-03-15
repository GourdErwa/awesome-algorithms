package io.groud.leetcode.algo.trie;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/replace-words/
 */
public class _648_JAVA_单词替换 {

    class Solution {
        class Trie {
            private class TrieNode {
                private TrieNode[] next = new TrieNode[26];
                private boolean word = false;
            }

            private TrieNode root = new TrieNode();

            public Trie() {
            }

            public void insert(String word) {
                TrieNode tmp = root;
                for (char c : word.toCharArray()) {
                    int n = c - 'a';
                    if (tmp.next[n] == null) tmp.next[n] = new TrieNode();
                    tmp = tmp.next[n];
                }
                tmp.word = true;
            }

            // word 中是否包含字典前缀字符串，如果包含返回最短的，否则返回原单词
            public String startsWith(String word) {
                TrieNode tmp = root;
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    int n = c - 'a';
                    TrieNode trieNode = tmp.next[n];
                    if (trieNode == null) return word; // 未找到为原单词
                    if (trieNode.word) return word.substring(0, i + 1); // 最短词根直接返回
                    tmp = trieNode;
                }
                return word;
            }
        }

        public String replaceWords(List<String> dict, String sentence) {
            if (dict == null || dict.isEmpty()) return sentence;
            if (sentence == null || sentence.length() == 0) return sentence;

            // 初始化前缀树
            Trie trie = new Trie();
            for (String s : dict) trie.insert(s);

            // 字符串空格拆分后，逐个字符进行词根匹配
            StringBuilder sb = new StringBuilder(sentence.length());
            String[] split = sentence.split(" ");
            int length = split.length;
            for (int i = 0, splitLength = length - 1; i < splitLength; i++) {
                String s = split[i];
                sb.append(trie.startsWith(s)).append(" ");
            }
            sb.append(trie.startsWith(split[length - 1])); // 遗留最后一个字符无需拼接空格后缀
            return sb.toString();
        }
    }

}
