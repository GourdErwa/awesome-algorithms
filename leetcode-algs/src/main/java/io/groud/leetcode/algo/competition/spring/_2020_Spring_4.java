package io.groud.leetcode.algo.competition.spring;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Li.Wei by 2020/4/18
 */
public class _2020_Spring_4 {

    class SolutionBak {

        private class Node {
            private int count;
            private int index;

            public Node(int count, int index) {
                this.count = count;
                this.index = index;
            }

            @Override
            public String toString() {
                return "Node{" + "count=" + count + ", index=" + index + '}';
            }
        }

        public int minJump(int[] jump) {
            if (jump == null || jump.length == 0) {
                return 0;
            }
            int r = jump.length - 1; // 一直右跳次数

            Deque<Node> deque = new LinkedList<>();
            deque.addFirst(new Node(1, 0));
            int ans = r; // 最小次数
            while (!deque.isEmpty()) {
                System.out.println("deque for...");
                for (int size = deque.size(); size > 0; size--) {
                    Node node = deque.pollLast();
                    System.out.println("poll node = " + node);
                    int index = node.index;
                    int next = jump[index]; // 跳到的位置对应步数
                    if (index - next >= 0 && node.count < ans) {
                        deque.addFirst(new Node(node.count + 1, index - next)); // 左边
                    }
                    if (index + next >= r) { // 成功
                        ans = Math.min(ans, node.count);
                    } else {
                        deque.addFirst(new Node(node.count + 1, index + next)); // 右边
                    }
                }
            }
            return ans;
        }
    }

    class Solution {

        private class Node {
            private int count;
            private int index;

            public Node(int count, int index) {
                this.count = count;
                this.index = index;
            }
        }

        public int minJump(int[] jump) {
            if (jump == null || jump.length == 0) {
                return 0;
            }
            int r = jump.length - 1; // 一直右跳次数
            Deque<Node> deque = new LinkedList<>();
            deque.addFirst(new Node(1, 0));
            int ans = jump.length; // 最小次数
            while (!deque.isEmpty()) {
                for (int size = deque.size(); size > 0; size--) {
                    Node node = deque.pollLast();
                    int index = node.index;
                    int next = jump[index]; // 跳到的位置对应步数
                    if (index - next >= 0 && node.count <= ans) {
                        deque.addFirst(new Node(node.count + 1, index - next)); // 左边
                    }
                    if (index + next > r) { // 成功
                        ans = Math.min(ans, node.count + 1);
                    } else {
                        deque.addFirst(new Node(node.count + 1, index + next)); // 右边
                    }
                }
            }
            return ans;
        }
    }
}
