package io.groud.leetcode.algo.competition.spring_team;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * https://leetcode-cn.com/contest/season/2020-spring/problems/you-le-yuan-de-you-lan-ji-hua/
 *
 * 6. 游乐园的游览计划
 *
 * @author Li.Wei by 2020/4/25
 */
public class _2020_SpringTeam_6 {

    /**
     * 参数说明：
     * edges 表示路径
     * value[i] 表示自己的喜爱值
     *
     * 游玩路径说明：
     * 上午游玩路径为 A-B-C-A，下午路径为 A-B'-C'-A
     *
     * 输入：edges =
     * [
     * [0,1],
     * [0,2],
     * [0,3],
     * [0,4],
     * [0,5],
     * [1,3],
     * [2,4],
     * [2,5],
     * [3,4],
     * [3,5],
     * [4,5]
     * ],
     * value = [7,8,6,8,9,7]
     *
     * 输出：39
     *
     * 解释：喜爱值之和最高的方案之一是 3->0->1->3 与 3->4->5->3 。喜爱值最高为 7+8+8+9+7 = 39
     */
    private static class Solution {

        public int maxWeightBak(int[][] edges, int[] value) {
            if (edges == null || edges.length == 0) {
                return 0;
            }
            AtomicInteger ans = new AtomicInteger(); // result

            // 项目->该项目可走向的所有项目
            Map<Integer, Set<Integer>> projects = new HashMap<>();
            for (int[] edge : edges) {
                int v0 = edge[0];
                int v1 = edge[1];
                Set<Integer> set0 = projects.getOrDefault(v0, new HashSet<>());
                set0.add(v1);
                projects.put(v0, set0);

                Set<Integer> set1 = projects.getOrDefault(v1, new HashSet<>());
                set1.add(v0);
                projects.put(v1, set1);
            }

            for (Map.Entry<Integer, Set<Integer>> entry : projects.entrySet()) {
                Integer am1 = entry.getKey(); // 作为起始项目
                entry.getValue().forEach(am2 -> {
                    if (am1.equals(am2)) {
                        return;
                    }
                    projects.getOrDefault(am2, Collections.emptySet()).forEach(am3 -> {
                        if (am2.equals(am3) || am1.equals(am3)) {
                            return;
                        }
                        projects.getOrDefault(am3, Collections.emptySet()).forEach(am4 -> {
                            if (am4.equals(am1)) { // A-B-C-A
                                // 下午返回
                                entry.getValue().forEach(pm2 -> {
                                    if (am1.equals(pm2)) {
                                        return;
                                    }
                                    projects.getOrDefault(pm2, Collections.emptySet()).forEach(pm3 -> {
                                        if (pm2.equals(pm3) || am1.equals(pm3)) {
                                            return;
                                        }
                                        projects.getOrDefault(pm3, Collections.emptySet()).forEach(pm4 -> {
                                            if (pm4.equals(am1)) { // A-B'-C'-A
                                                Set<Integer> pro = new HashSet<>();
                                                pro.add(am1);
                                                pro.add(am2);
                                                pro.add(am3);
                                                pro.add(pm2);
                                                pro.add(pm3);
                                                int sum = pro.stream().mapToInt(p -> value[p]).sum();
                                                // System.out.println("" + am1 + "," + am2 + "," + am3 + "," + am4 + " :
                                                // "
                                                // + am4 + "," + pm2 + "," + pm3 + "," + pm4 + " : sum=" + sum);
                                                ans.set(Math.max(sum, ans.get()));
                                                pro.clear();
                                            }
                                        });
                                    });
                                });
                            }
                        });
                    });
                });
            }
            return ans.get();
        }

        public int maxWeight(int[][] edges, int[] value) {
            if (edges == null || edges.length == 0) {
                return 0;
            }
            int ans = 0; // result

            // 项目->该项目可走向的所有项目
            Map<Integer, Set<Integer>> projects = new HashMap<>();
            for (int[] edge : edges) {
                int v0 = edge[0];
                int v1 = edge[1];
                Set<Integer> set0 = projects.getOrDefault(v0, new HashSet<>());
                set0.add(v1);
                projects.put(v0, set0);

                Set<Integer> set1 = projects.getOrDefault(v1, new HashSet<>());
                set1.add(v0);
                projects.put(v1, set1);
            }

            // PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
            List<Set<Integer>> list = new ArrayList<>();

            for (Map.Entry<Integer, Set<Integer>> entry : projects.entrySet()) {
                Integer am1 = entry.getKey(); // 作为起始项目
                entry.getValue().forEach(am2 -> {
                    if (am1.equals(am2)) {
                        return;
                    }
                    projects.getOrDefault(am2, Collections.emptySet()).forEach(am3 -> {
                        if (am2.equals(am3) || am1.equals(am3)) {
                            return;
                        }
                        projects.getOrDefault(am3, Collections.emptySet()).forEach(am4 -> {
                            if (am4.equals(am1)) { // A-B-C-A
                                Set<Integer> set = new HashSet<>();
                                set.add(am2);
                                set.add(am3);
                                // System.out.println("" + am1 + "," + am2 + "," + am3 + "," + am4);
                                list.add(set);
                            }
                        });
                    });
                });

                if (list.size() > 1) {
                    for (Set<Integer> set1 : list) {
                        for (Set<Integer> set2 : list) {
                            HashSet<Integer> dup = new HashSet<>(set1);
                            dup.addAll(set2);

                            // System.out.println(dup);
                            int sum = value[am1];
                            for (Integer o : dup) {
                                sum += value[o];
                            }
                            // System.out.println(sum);
                            ans = Math.max(sum, ans);
                        }
                    }
                }
                list.clear();
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxWeight(
            new int[][] {{0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}, {1, 3}, {2, 4}, {2, 5}, {3, 4}, {3, 5}, {4, 5}},
            new int[] {7, 8, 6, 8, 9, 7}) == 39);

        System.out.println(solution.maxWeight(new int[][] {{0, 2}, {2, 1}}, new int[] {1, 2, 5}) == 0);

        System.out.println(solution.maxWeight(new int[][] {{0, 1}, {1, 2}, {0, 2}}, new int[] {1, 2, 3}) == 6);
    }
}
