package com.java.leetcode.medium;

import java.util.Arrays;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target
 * number.
 * The function twoSum should return indices of the two numbers such that they add up to
 * the target, where index1 must be less than index2. Please note that your returned answers
 * (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * the input array is already sorted in ascending order.
 *
 * @author mti1301
 * @since 2015/6/15.
 */
public class TwoSumII_InputArrayIsSorted {
    public static void main(String[] args) {
        int[] nums = {9, 1, 2, 3, 5, 6, 8, 10};
        System.out.println(Arrays.toString(new TwoSumII_InputArrayIsSorted().twoSum_BinarySearch(nums, 19)));
    }

    // Two Pointers  O(n) runtime O(1) space
    public int[] twoSum_2Pointers(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;

        while (low < high) {
            if (numbers[low] + numbers[high] == target) {
                return new int[]{low + 1, high + 1}; // index1 and index2 not zero-based
            } else if (numbers[low] + numbers[high] < target) {
                while (++low < high && numbers[low - 1] == numbers[low]) ;
            } else {
                while (low < --high && numbers[high + 1] == numbers[high]) ;
            }
        }
        throw new IllegalStateException("error state");
    }


    // Binary Search runtime o(n*log(n)) space o(1)
    public int[] twoSum_BinarySearch(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int re = binarySearch(nums, i + 1, target - x);
            if (-1 != re) {
                return new int[]{i + 1, re + 1};
            }
        }
        throw new IllegalStateException("error state");
    }

    private int binarySearch(int[] nums, int start, int target) {
        int end = nums.length - 1;
        int mid;
        while (start < end) {
            mid = (end + start) / 2;
            if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return (start == end && nums[start] == target) ? start : -1;
    }
}
