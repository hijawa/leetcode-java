package com.java.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers and an integer k,
 * find out whether there are two distinct indices i and j in the array
 * such that nums[i] = nums[j] and the difference between i and j is at most k.
 *
 * @author mti1301
 * @since 2015/6/10.
 */
public class ContainsDuplicateII {

    public static void main(String[] args) {
//        int[] nums = {1,2,1};
        int[] nums = new int[29999];
        for(int i=0;i<29999;i++){
            nums[i] = i;
        }
        long start = System.currentTimeMillis();
        System.out.println(new ContainsDuplicateII().containsNearbyDuplicate1(nums, 29999));
        System.out.println(System.currentTimeMillis() - start);
    }

    // Solution 1 ：能运行 但是可能会超时 不好
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        if (len < 2) {
            return false;
        }
        int i = 0, j = i + 1;
        while (true) {
            if (j < Math.min(len, i + k + 1)) {
                if (nums[i] == nums[j]) {
                    if (i != j) {
                        System.out.println("i= " + i + ",j= " + j);
                        return true;
                    }
                } else {
                    ++j;
                }
            } else {
                ++i;
                j = i + 1;
                if (i >= len) {
                    break;
                }
            }
        }
        return false;
    }

    // Solution 2 比较好
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        int len = nums.length;
        if (len < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            Integer value = map.get(nums[i]);
            if (value != null && Math.abs(value - i) <=k) {
                return true;
            }else {
                map.put(nums[i],i);
            }
        }
        return false;
    }
}
