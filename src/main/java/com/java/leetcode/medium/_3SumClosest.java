package com.java.leetcode.medium;

import java.util.Arrays;

/**
 * @author haoqi.thq
 * @version $Id: _3SumClosest, v 0.1 2016/9/24 14:50 haoqi.thq Exp $
 */
public class _3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int distance = Integer.MAX_VALUE;
        int len = nums.length;
        int result = 0;
        for (int i = 0; i < len - 2; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int a = nums[i];
            int low = i + 1;
            int high = len - 1;
            while (low < high) {
                int b = nums[low];
                int c = nums[high];
                int sum = a + b + c;
                if (sum == target) {
                    return sum;
                }

                if (Math.abs(sum - target) < distance) {
                    result = sum;
                    distance = Math.abs(sum - target);
                }

                if (sum < target) {
                    while (low < len-1 && nums[low] == nums[low + 1]) low++;
                    low++;
                } else {
                    while (high > 0 && nums[high] == nums[high - 1]) high--;
                    high--;
                }
            }

        }
        return result;
    }
}
