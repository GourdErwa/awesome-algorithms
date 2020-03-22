package io.groud.leetcode.algo.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 */
public class _208_JAVA_实现前缀树 {

    // 前缀树-List 实现子节点
    static class Trie {
        private class Node {
            private char c;
            private boolean has;
            private List<Node> child = new ArrayList<>();

            public Node() {}

            public Node(char c) {
                this.c = c;
            }
        }

        private final Node root = new Node();

        public Trie() {}

        public void insert(String word) {
            int length = word.length();
            Node curr = root;
            for (int i = 0; i < length; i++) {
                char c = word.charAt(i);
                boolean find = false;
                for (Node node : curr.child) {
                    if (node.c == c) {
                        curr = node;
                        find = true;
                        break;
                    }
                }
                if (!find) { // 如果该字符在子节点中未找到，直接将剩余字符添加后跳出
                    for (int y = i; y < length; y++) {
                        Node e = new Node(word.charAt(y));
                        curr.child.add(e);
                        curr = e;
                    }
                    break;
                }
            }
            curr.has = true;
        }

        public boolean search(String word) {
            Node node = searchHelper(word);
            return node != null && node.has;
        }

        public boolean startsWith(String prefix) {
            return searchHelper(prefix) != null;
        }

        // 如果没有找到最终节点返回 null
        private Node searchHelper(String word) {
            int length = word.length();
            Node curr = root;
            for (int i = 0; i < length; i++) {
                if (curr.child.isEmpty())
                    return null;
                char c = word.charAt(i);
                boolean find = false;
                for (Node node : curr.child) {
                    if (node.c == c) {
                        curr = node;
                        find = true;
                        break;
                    }
                }
                if (!find)
                    return null;
            }
            return curr;
        }
    }

    // 前缀树-官方推荐答案实现-优化版本，使用 HashMap 存放
    // https://leetcode-cn.com/explore/learn/card/trie/166/basic-operations/646/
    class Trie1 {
        private class TrieNode {
            public boolean word;
            public Map<Character, TrieNode> childrenMap = new HashMap<>();
        }

        private TrieNode root = new TrieNode();

        public Trie1() {}

        public void insert(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                cur = cur.childrenMap.computeIfAbsent(c, character -> new TrieNode());
            }
            cur.word = true;
        }

        public boolean search(String word) {
            TrieNode trieNode = searchHelper(word);
            return trieNode != null && trieNode.word;
        }

        public boolean startsWith(String prefix) {
            return searchHelper(prefix) != null;
        }

        public TrieNode searchHelper(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                TrieNode trieNode = cur.childrenMap.get(c);
                if (trieNode == null)
                    return null;
                cur = trieNode;
            }
            return cur;
        }
    }

    // 前缀树-通过小写字母范围直接申请 26 个子节点数组存放
    class Trie2 {
        private class TrieNode {
            private TrieNode[] next = new TrieNode[26];
            private boolean word = false;
        }

        private TrieNode root = new TrieNode();

        public Trie2() {}

        public void insert(String word) {
            TrieNode tmp = root;
            for (char c : word.toCharArray()) {
                int n = c - 'a';
                if (tmp.next[n] == null)
                    tmp.next[n] = new TrieNode();
                tmp = tmp.next[n];
            }
            tmp.word = true;
        }

        public boolean search(String word) {
            TrieNode trieNode = searchHelper(word);

            return trieNode != null && trieNode.word;
        }

        public boolean startsWith(String prefix) {

            return searchHelper(prefix) != null;
        }

        private TrieNode searchHelper(String word) {
            TrieNode tmp = root;
            for (char c : word.toCharArray()) {
                int n = c - 'a';
                TrieNode trieNode = tmp.next[n];
                if (trieNode == null)
                    return null;
                tmp = trieNode;
            }
            return tmp;
        }
    }

    /*
    ["Trie","insert","insert","insert","insert","insert","insert","search","search","search","search","search","search","search","search","search","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith","startsWith"]
    [[],["app"],["apple"],["beer"],["add"],["jam"],["rental"],["apps"],["app"],["ad"],["applepie"],["rest"],["jan"],["rent"],["beer"],["jam"],["apps"],["app"],["ad"],["applepie"],["rest"],["jan"],["rent"],["beer"],["jam"]]
    */
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("app");
        trie.insert("apple");
        trie.insert("beer");
        trie.insert("add");
        trie.insert("jam");
        trie.insert("rental");

        System.out.println(trie.startsWith("jam"));
        System.out.println(trie.startsWith("ad"));
    }
    /*
     Trie trie = new Trie();

     trie.insert("apple");
     trie.search("apple");   // 返回 true
     trie.search("app");     // 返回 false
     trie.startsWith("app"); // 返回 true
     trie.insert("app");
     trie.search("app");     // 返回 true

     */
}
