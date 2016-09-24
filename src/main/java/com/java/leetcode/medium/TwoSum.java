package com.java.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * <p/>
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * <p/>
 * You may assume that each input would have exactly one solution.
 * <p/>
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 *
 * @author Googny
 * @since 2015/6/11.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {1, 1, 11, 15};
        int target = 2;
        System.out.println(Arrays.toString(new TwoSum().twoSum_2Pointers(nums, target)));
    }

    // Assume that each input would have exactly one solution;

    // Hash Map 1
    public int[] twoSum_hashMap1(int[] nums, int target) {
        // map 存储 不相等元素的值和位置索引
        Map<Integer, Integer> map = new HashMap<>();
        /*
         location 存储相等元素的值和位置索引数组
         不过这里的location 只保存了两个相等元素的位置，针对 target 等于两个相等元素之和的情况
          */
        Map<Integer, int[]> location = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer value = map.get(nums[i]);
            if (value != null) {
                location.put(nums[i], new int[]{value, (i + 1)});
            }
            map.put(nums[i], i + 1);
        }
        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            int els = target - key;
            if (map.get(els) != null) {
                if (els == key) { //target 等于两个相等元素之和
                    return location.get(els);
                }
                return new int[]{Math.min(map.get(key), map.get(els)), Math.max(map.get(key), map.get(els))};
            }
        }
        return null;
    }

    // Hash Map2 明显比我自己的解决方案优雅 good   o(n) runtime o(n) space
    public int[] twoSum_hashMap2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]) + 1, i + 1};
            }
            map.put(nums[i], i);
        }
        throw new IllegalStateException("error state");
    }


    /*
    Two Pointers  该方法改变了nums的顺序  o(n*log(n)) runtime o(1) space
     */
    public int[] twoSum_2Pointers(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                return new int[]{left + 1, right + 1};
            }
            if (nums[left] + nums[right] > target) {
                // 无论下标为 right -1 的元素是否有意义
                // --right;

                // 跳过无意义的相等元素 good
                while (left < --right && nums[right] == nums[right + 1]) ;
            }
            if (nums[left] + nums[right] < target) {
                // 无论下标为 left +1 的元素是否有意义
                // ++left;

                // 跳过无意义的相等元素
                while (++left < right && nums[left - 1] == nums[left]) ;
            }
        }
        return null;
    }

}
