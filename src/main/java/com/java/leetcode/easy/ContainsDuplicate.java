package com.java.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 *
 * @author mti1301
 * @since 2015/6/10.
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        long start = System.currentTimeMillis();
        System.out.println(new ContainsDuplicate().containsDuplicate(nums));
        System.out.println(System.currentTimeMillis() - start);
    }

    public boolean containsDuplicate(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.get(nums[i]) != null) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
}
