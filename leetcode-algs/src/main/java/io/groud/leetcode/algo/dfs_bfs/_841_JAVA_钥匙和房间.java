package io.groud.leetcode.algo.dfs_bfs;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/keys-and-rooms/ tag：dfs、bfs
 *
 * @author Li.Wei by 2020/3/4
 */
public class _841_JAVA_钥匙和房间 {

    /**
     * bfs , 记忆访问过的房间，最终比对访问与总房间数 使用双向队列，修改入队出队方式直接变为 dfs 遍历即可。
     * <p>
     * visited.add(r) 判断比使用 visited.contains 方法没有再 add 性能更优。 因为 hashSet 底层使用 hashMap 实现，判断重复时候已经可以拿到返回值。 尤其在出现 hash
     * 冲突时，两次操作耗时更长
     */
    class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            if (rooms == null || rooms.isEmpty())
                return true;
            Set<Integer> visited = new HashSet<>(); // 访问过的房间号
            Deque<List<Integer>> queue = new LinkedList<>();
            queue.add(rooms.get(0));
            visited.add(0);
            while (!queue.isEmpty()) {
                for (Integer r : queue.poll()) {
                    if (visited.add(r))
                        queue.add(rooms.get(r)); // 如果未访问过进行遍历
                }
            }
            return visited.size() == rooms.size();
        }
    }
}
