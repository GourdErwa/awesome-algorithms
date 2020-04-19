package io.groud.leetcode.algo.competition.week;

import java.util.*;

/**
 * https://leetcode-cn.com/contest/weekly-contest-185/problems/display-table-of-food-orders-in-a-restaurant/
 * 5389. 点菜展示表
 *
 * @author Li.Wei by 2020/4/19
 */
public class _185_WEEK_2 {

    /**
     * 输入：orders = [
     * ["David","3","Ceviche"],
     * ["Corina","10","Beef Burrito"],
     * ["David","3","FriedChicken"],
     * ["Carla","5","Water"],
     * ["Carla","5","Ceviche"],
     * ["Rous","3","Ceviche"]
     * ]
     *
     * 输出：[
     * ["Table","Beef Burrito","Ceviche","FriedChicken","Water"],
     * ["3","0","2","1","0"],
     * ["5","0","1","0","1"],
     * ["10","1","0","0","0"]
     * ]
     *
     * 解释：
     * 点菜展示表如下所示：
     * Table,Beef Burrito,Ceviche,Fried Chicken,Water
     * 3 ,0 ,2 ,1 ,0
     * 5 ,0 ,1 ,0 ,1
     * 10 ,1 ,0 ,0 ,0
     *
     * 对于
     * 餐桌 3：David 点了 "Ceviche" 和 "Fried Chicken"，而 Rous 点了 "Ceviche"
     * 餐桌 5：Carla 点了 "Water" 和 "Ceviche"
     * 餐桌 10：Corina 点了 "Beef Burrito"
     */
    class Solution {
        public List<List<String>> displayTable(List<List<String>> orders) {
            if (orders == null || orders.isEmpty()) {
                return Collections.emptyList();
            }

            // TreeMap<Table, TreeMap<菜名, 数量>>
            TreeMap<Integer, TreeMap<String, Integer>> treeMap = new TreeMap<>();
            for (List<String> order : orders) {
                int table = Integer.parseInt(order.get(1));
                String cd = order.get(2);
                TreeMap<String, Integer> tVal = treeMap.get(table);
                if (tVal == null) {
                    TreeMap<String, Integer> cdMap = new TreeMap<>();
                    cdMap.put(cd, 1);
                    treeMap.put(table, cdMap);
                } else {
                    tVal.put(cd, tVal.getOrDefault(cd, 0) + 1);
                }
            }

            List<List<String>> ans = new ArrayList<>();

            TreeSet<String> cdSet = new TreeSet<>();
            for (TreeMap<String, Integer> value : treeMap.values()) {
                cdSet.addAll(value.keySet());
            }

            List<String> head = new ArrayList<>(); // 标题
            head.add("Table");
            head.addAll(cdSet);
            ans.add(head);

            SortedSet<Integer> tableSet = treeMap.navigableKeySet();
            for (Integer t : tableSet) {
                List<String> row = new ArrayList<>();
                row.add(t.toString());

                TreeMap<String, Integer> map = treeMap.get(t);
                for (int i = 1; i < head.size(); i++) {
                    if (map == null) {
                        row.add("0");
                    } else {
                        row.add(map.getOrDefault(head.get(i), 0).toString());
                    }
                }
                ans.add(row);
            }
            return ans;
        }
    }
}
