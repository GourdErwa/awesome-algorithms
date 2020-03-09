/**
 * @author Li.Wei by 2020/3/5
 */
package io.groud.leetcode.algo.dfs_bfs;

import java.util.*;

/**
 * bfs , 记忆访问过的房间，最终比对访问与总房间数
 * 使用双向队列，修改入队出队方式直接变为 dfs 遍历即可。
 * <p>
 * visited.add(r) 判断比使用 visited.contains 方法没有再 add 性能更优。
 * 因为 hashSet 底层使用 hashMap 实现，判断重复时候已经可以拿到返回值。
 * 尤其在出现 hash 冲突时，两次操作耗时更长
 * <p>
 * 针对记忆法，可以使用数组存放 boolean，也可以用 hashSet
 * <p>
 * Stack<Integer> stack = new Stack(); 推荐使用双向队列 Deque，因为 Stack 是同步集合，可查看源码。
 */
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.isEmpty()) return true;
        Set<Integer> visited = new HashSet<>(); // 访问过的房间号
        Deque<List<Integer>> queue = new LinkedList<>();
        queue.add(rooms.get(0));
        visited.add(0);
        while (!queue.isEmpty()) {
            for (Integer r : queue.poll()) {
                if (visited.add(r)) queue.add(rooms.get(r)); // 如果未访问过进行遍历
            }
        }
        return visited.size() == rooms.size();
    }
}