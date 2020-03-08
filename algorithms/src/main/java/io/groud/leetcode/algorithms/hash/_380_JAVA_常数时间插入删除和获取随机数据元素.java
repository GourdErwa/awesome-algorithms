package io.groud.leetcode.algorithms.hash;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/insert-delete-getrandom-o1/
 * <p>
 * 思路：
 * 1.如果采用 jdk set 集合，则随机性无法使用，无法随机访问数据
 *
 * @author Li.Wei by 2020/3/8
 */
public class _380_JAVA_常数时间插入删除和获取随机数据元素 {
    /**
     * Map<当前值, 当前值对应 List 下标>
     */
    static class RandomizedSet {

        private final Map<Integer, Integer> map = new HashMap<>();
        private final List<Integer> list = new ArrayList<>();
        private final Random random = new Random();

        public RandomizedSet() {
        }

        public boolean insert(int val) {
            Integer v = map.get(val);
            if (v == null) {
                // 当前值在列表下标设置为 size，因为后序列表立即 add 到 [size]位置。
                map.put(val, list.size());
                list.add(val);
                return true;
            }
            return false;
        }

        // 拿到当前删除的值，及对应列表的下标
        // 如果当前删除值不是列表最后一个数据，需要将列表最后一个位置的数据放入当前删除值的下标，然后删除列表最后一个数据
        // map 也做最后的修改
        public boolean remove(int val) {
            Integer currValIndex = map.remove(val); // 当前删除值对应列表的下标
            if (currValIndex == null) return false; // 不存在直接返回

            int count = list.size() - 1; // 当前列表元素个数

            if (currValIndex == count) { // 如果删除的是列表最后一个数据，直接移除即可
                list.remove(count);
                return true;
            }

            Integer listLastVal = list.remove(count); // 取到列表最后一个数据
            list.set(currValIndex, listLastVal); // 列表最后一个位置的数据放入当前删除值的下标
            map.put(listLastVal, currValIndex); // map 做同步修改
            return true;
        }

        public int getRandom() {
            return list.isEmpty() ? -1 : list.get(random.nextInt(list.size()));
        }
    }

    /*
    ["RandomizedSet","remove","remove","insert","getRandom","remove","insert"]
    [[],[0],[0],[0],[],[0],[0]]

    ["RandomizedSet","insert","remove","insert","getRandom","remove","insert","getRandom"]
    [[],[1],[2],[2],[],[1],[2],[]]

    ["RandomizedSet","insert","insert","getRandom","getRandom","insert","remove","getRandom","getRandom","insert","remove"]
    [[],[3],[3],[],[],[1],[3],[],[],[0],[0]]
     */
    public static void main(String[] args) {
        RandomizedSet r = new RandomizedSet();
        r.remove(0);
        r.remove(0);
        r.insert(0);
        r.getRandom();
        r.remove(0);
        r.insert(0);
    }
}
