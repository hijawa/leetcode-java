package com.java.leetcode.medium;

/**
 * Given an array of n positive integers and a positive integer s,
 * find the minimal length of a subarray of which the sum ≥ s.
 * If there isn't one, return 0 instead.
 * <p>
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 * <p>
 * More practice:
 * If you have figured out the O(n) solution,
 * try coding another solution of which the time complexity is O(n log n).
 *
 * @author mti1301
 * @since 2015/6/15.
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
//        int[] nums = {5, 1, 3, 5, 10, 7, 4, 9, 2, 8};
        int[] nums = {1, 1};
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(3, nums));
    }

    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return len;
        }
        if (len == 1) {
            if (nums[0] >= s) {
                return len;
            } else {
                return 0;
            }
        }

        int i = 0;
        int j = i + 1;
        int size = 0;
        int minSize = len;
        int sum = nums[i] + nums[j];
        while (j < len) {
            if (nums[0] >= s) {
                return 1;
            }
            while (sum < s && j < len) {
                if (++j >= len) {
                    break;
                }
                sum += nums[j];
            }
            if (sum >= s) {
                size = j - i + 1;
                minSize = Math.min(minSize, size);
                sum -= nums[i++];
                while (sum >= s) {
                    size--;
                    minSize = Math.min(minSize, size);
                    sum -= nums[i++];
                }
            }
        }
        minSize = Math.min(minSize,size);
        return minSize;
    }
}
