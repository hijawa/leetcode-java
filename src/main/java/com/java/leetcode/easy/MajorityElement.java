package com.java.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p/>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * @author mti1301
 * @since 2015/6/10.
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6};
//        int key = 0;
//        for(int elem:nums){
//            key ^=elem;
//        }
//        System.out.println(key);
        System.out.println(new MajorityElement().majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            Integer value = map.get(nums[i]);
            if (value != null) {
                value++;
                map.put(nums[i], value);
            } else {
                map.put(nums[i], 1);
            }
        }
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            Integer value = map.get(key);
            if (value > len / 2) {
                return key;
            }
        }
        return 0;
    }

    //Boyer-Moore Majority Vote Algorithm
    public int majorityElement_fastest(int[] num) {

        int major = num[0], count = 1;
        for (int i = 1; i < num.length; i++) {
            if (count == 0) {
                count++;
                major = num[i];
            } else if (major == num[i]) {
                count++;
            } else count--;
        }
        return major;
    }
}
