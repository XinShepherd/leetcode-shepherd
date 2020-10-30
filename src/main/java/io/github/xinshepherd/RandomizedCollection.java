package io.github.xinshepherd;

import java.util.LinkedHashSet;

/**
 * @author Fuxin
 * @since 2020/10/31
 */
public class RandomizedCollection {

    private LinkedHashSet<Integer> container = new LinkedHashSet<>();

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection() {

    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        return container.add(val);
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        return container.remove(val);
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {

    }

    /**
     * Your RandomizedCollection object will be instantiated and called as such:
     * RandomizedCollection obj = new RandomizedCollection();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */
    public static void main(String[] args) {
        // 初始化一个空的集合。
        RandomizedCollection collection = new RandomizedCollection();

        // 向集合中插入 1 。返回 true 表示集合不包含 1 。
        collection.insert(1);

        // 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
        collection.insert(1);

        // 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
        collection.insert(2);

        // getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
        collection.getRandom();

        // 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
        collection.remove(1);

        // getRandom 应有相同概率返回 1 和 2 。
        collection.getRandom();
    }
}
