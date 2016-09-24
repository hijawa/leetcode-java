package com.java.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Design and implement a TwoSum class. It should support the following operations: add
 * and find.
 * add(input) – Add the number input to an internal data structure.
 * find(value) – Find if there exists any pair of numbers which sum is equal to the value.
 * For example,
 * add(1); add(3); add(5); find(4)  true; find(7)  false
 *
 * @author mti1301
 * @since 2015/6/12.
 */
public class TwoSumIIIDatastructuredesign {

    private Map<Integer, Integer> hashMap;

    public TwoSumIIIDatastructuredesign() {
        hashMap = new HashMap<>();
    }

    public static void main(String[] args) {
        TwoSumIIIDatastructuredesign twosum = new TwoSumIIIDatastructuredesign();
        twosum.add(1);
        twosum.add(3);
        twosum.add(3);
        twosum.add(4);
        System.out.println(twosum.find(6));
    }

    public void add(int val) {
        int count = hashMap.containsKey(val) ? hashMap.get(val) : 0;
        hashMap.put(val, count + 1);
    }

    public boolean find(int val) {
        Set<Integer> keys = hashMap.keySet();
        for (Integer key : keys) {
            int remain = val - key;
            if (remain == key && hashMap.get(key) >= 2) {
                return true;
            } else if (hashMap.containsKey(remain)) {
                return true;
            }
        }
        return false;
    }
}
