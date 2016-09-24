package com.java.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, every element appears twice except for one.
 * Find that single one.
 * <p/>
 * Note:
 * Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 *
 * @author mti1301
 * @since 2015/6/30.
 */
public class SingleNumber {

    /**
     * HashMap 解决方案
     *
     * @param nums 待查找的数组
     * @return 返回single Number
     */
    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        throw new IllegalStateException("error state");
    }
}
