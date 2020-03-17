package io.groud.leetcode.algo.heap;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 *
 * @author Li.Wei by 2020/3/8
 */
public class _347_JAVA_前K个高频元素 {

    // hashMap + TreeSet
    static class Solution {

        private class Node implements Comparable<Node> {
            private int val;
            private int count;

            public Node(int val, int count) {
                this.val = val;
                this.count = count;
            }

            public Node incrementCount() {
                count++;
                return this;
            }

            // TreeSet 放入元素，如果比较值为 0 认为重复!!!，所以我们为了出现同样次数的不同字符，需要进行特殊处理
            @Override
            public int compareTo(Node o) {
                int diff = o.count - count;
                if (diff == 0)
                    return val - o.val;
                return diff;
            }
        }

        public List<Integer> topKFrequent(int[] nums, int k) {
            if (nums.length == 1)
                return null;
            Map<Integer, Node> map = new HashMap<>();
            // 使用 map 进行计数 ，也可使用数组但是编码复杂性较高
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, new Node(num, 0)).incrementCount());
            }
            SortedSet<Node> set = new TreeSet<>(map.values()); // 使用 TreeSet 排序，排序使用 Node.count 比较
            Iterator<Node> iterator = set.iterator();

            List<Integer> r = new ArrayList<>(k); // 最终返回值
            while (k-- > 0 && iterator.hasNext()) { // TreeSet 迭代取前 k
                r.add(iterator.next().val);
            }
            return r;
        }
    }

    // hashMap + PriorityQueue
    static class Solution1 {

        private class Node implements Comparable<Node> {
            private int val;
            private int count;

            public Node(int val, int count) {
                this.val = val;
                this.count = count;
            }

            public Node incrementCount() {
                count++;
                return this;
            }

            @Override
            public int compareTo(Node o) {
                return o.count - count;
            }
        }

        public List<Integer> topKFrequent(int[] nums, int k) {
            Map<Integer, Node> map = new HashMap<>();
            // 使用 map 进行计数 ，也可使用数组但是编码复杂性较高
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, new Node(num, 0)).incrementCount());
            }

            PriorityQueue<Node> queue = new PriorityQueue<>(map.values()); // 使用堆排序，排序使用 Node.count 比较
            List<Integer> r = new ArrayList<>(k); // 最终返回值

            for (int i = Math.min(k, queue.size()); i > 0; i--) {
                r.add(queue.poll().val);
            }
            return r;
        }
    }

    // 数组排序记录出现次数，出现次数记录再次排序取最值
    class Solution3 {
        // 前 K 个高频元素
        public List<Integer> topKFrequent(int[] nums, int k) {
            List<Integer> list = new ArrayList();
            Arrays.sort(nums);
            int distinctLen = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[i - 1]) {
                    distinctLen++;
                }
            }
            int counts[] = new int[distinctLen];
            int order[] = new int[distinctLen];
            int index = 0;
            int count = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i - 1]) {
                    count++;
                } else {
                    counts[index] = count;
                    order[index] = count;
                    nums[index] = nums[i - 1];
                    index++;
                    count = 1;
                }
            }
            nums[index] = nums[nums.length - 1];
            counts[index] = count;
            order[index] = count;
            Arrays.sort(order);
            int kth = order[distinctLen - k];
            for (int i = 0; i <= index; i++) {
                if (counts[i] >= kth) {
                    list.add(nums[i]);
                }
            }
            return list;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // List<Integer> integers = solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 2, 2, 3}, 2);
        List<Integer> integers = solution.topKFrequent(new int[] {1, 2}, 2);
        System.out.println(integers);
    }
}
