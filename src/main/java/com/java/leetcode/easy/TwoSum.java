package com.java.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author haoqi.thq
 * @version $Id: TwoSum.java, v 0.1 2016-09-21 下午9:19 haoqi.thq Exp $
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer,int[]> location = new HashMap<>();
        for (int i = 0; i < len; i++) {
            Integer value = map.get(nums[i]);
            if(value != null){
                location.put(nums[i],new int[]{value,(i+1)});
            }
            map.put(nums[i], i + 1);
        }
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            int els = target - key;
            if (map.get(els) != null) {
                if(els == key){
                    return location.get(els);
                }
                return new int[]{Math.min(map.get(key), map.get(els)), Math.max(map.get(key), map.get(els))};
            }
        }
        return new int[0];
    }
}
