/**
 * @author Li.Wei by 2020/3/6
 */
package io.groud.leetcode.algorithms.hash;

import java.util.*;

/**
 * Map<当前值, 当前值对应 List 下标>
 * List[下标] = 当前值
 * <p>
 * 因为随机访问，所以哈希不支持，需要配合列表实现。
 * 随机访问的特性，需要列表保证能动态的删除值，收缩长度。
 */
class RandomizedSet {

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