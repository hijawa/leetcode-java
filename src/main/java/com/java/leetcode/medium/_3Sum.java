package com.java.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author haoqi.thq
 * @version $Id: _3Sum, v 0.1 2016/9/24 14:48 haoqi.thq Exp $
 */
public class _3Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new LinkedList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue; //已经计算过的就跳过
            int a = nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int _2Sum = nums[left] + nums[right];
                if (_2Sum > -a) {
                    do {
                        right--;
                    } while (left < right && nums[right] == nums[right + 1]);
                } else if (_2Sum < -a) {
                    do {
                        left++;
                    } while (left < right && nums[left] == nums[left - 1]);
                } else {
                    List<Integer> item = new LinkedList<>();
                    item.add(a);
                    item.add(nums[left]);
                    item.add(nums[right]);
                    lists.add(item);
                    do {
                        right--;
                    } while (left < right && nums[right] == nums[right + 1]);
                    do {
                        left++;
                    } while (left < right && nums[left] == nums[left - 1]);
                }
            }
        }
        return lists;
    }
}
