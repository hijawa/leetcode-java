package com.java.leetcode.medium;

import java.util.*;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * The algorithm should run in linear time and in O(1) space.
 *
 * @author mti1301
 * @since 2015/6/29.
 */
public class MajorityElementII {


    // 不优雅
    public List<Integer> majorityElement(int[] nums) {
        if (null == nums) return Collections.emptyList();
        Map<Integer, Integer> map = new HashMap();
        Set<Integer> result = new HashSet();
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            int x = nums[i];
            if (!map.containsKey(x)) {
                map.put(x, 1);
                // for len = 1,2,3
                if (map.get(x) > len / 3) {
                    result.add(x);
                }
            } else {
                map.put(x, map.get(x) + 1);
                if (map.get(x) > len / 3) {
                    result.add(x);
                }
            }
        }
        return new LinkedList(result);
    }
}
