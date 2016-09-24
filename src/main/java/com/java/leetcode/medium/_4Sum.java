package com.java.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author haoqi.thq
 * @version $Id: _4Sum, v 0.1 2016/9/24 14:55 haoqi.thq Exp $
 */
public class _4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new LinkedList<>();
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int a = nums[i];
            int _3Sum = target - a;
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int b = nums[j];
                int _2Sum = _3Sum - b;
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[left] + nums[right];
                    if (sum > _2Sum) {
                        do {
                            right--;
                        } while (left < right && nums[right] == nums[right + 1]);
                    } else if (sum < _2Sum) {
                        do {
                            left++;
                        } while (left < right && nums[left] == nums[left - 1]);
                    } else {
                        List<Integer> item = new LinkedList<>();
                        item.add(a);
                        item.add(b);
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
        }
        return lists;
    }
}
