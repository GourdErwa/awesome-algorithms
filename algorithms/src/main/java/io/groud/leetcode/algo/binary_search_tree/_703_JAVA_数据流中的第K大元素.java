package io.groud.leetcode.algo.binary_search_tree;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 *
 * @author Li.Wei by 2020/2/24
 */
public class _703_JAVA_数据流中的第K大元素 {
    static class KthLargest {

        private final PriorityQueue<Integer> queue;
        private int k;

        public KthLargest(int k, int[] nums) {
            queue = new PriorityQueue<>(k);
            this.k = k;
            for (int num : nums) {
                this.add(num);
            }
        }

        public int add(int val) {
            queue.offer(val); // 任何时候都需要加入优先队列中进行更新
            if (queue.size() > k) queue.poll();  // 如果刚刚比较的结果越界移除末尾
            return queue.peek();
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, arr);
        System.out.println(kthLargest.add(3));   // returns 4
        System.out.println(kthLargest.add(5));   // returns 5
        System.out.println(kthLargest.add(10));  // returns 5

        System.out.println(kthLargest.add(9));   // returns 8
        System.out.println(kthLargest.add(4));   // returns 8
    }
}

