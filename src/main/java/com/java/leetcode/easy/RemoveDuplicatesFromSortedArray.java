package com.java.leetcode.easy;

import java.util.Arrays;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once
 * and return the new length.
 * <p/>
 * Do not allocate extra space for another array,
 * you must do this in place with constant memory.
 * <p/>
 * For example,
 * Given input array nums = [1,1,2],
 * <p/>
 * Your function should return length = 2,
 * with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the new length.
 *
 * @author mti1301
 * @since 2015/6/10.
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
//        int[] nums = {1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 5, 6, 6, 7};
        int[] nums = {1, 1,2,2,3,3,3,4};
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates1(nums));
    }

    // Solution 1
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] shadow = new int[len];
        int shadowIndex = 0;
        int count = 0;
        int pre = nums[0];
        for (int i = 1; i < len; i++) {
            if (pre == nums[i]) {
                ++count;
                continue;
            }
            shadow[shadowIndex++] = pre;
            pre = nums[i];
        }
        shadow[shadowIndex++] = pre;
        System.arraycopy(shadow, 0, nums, 0, shadowIndex);
        System.out.println(Arrays.toString(shadow));
        System.out.println(Arrays.toString(nums));
        return len - count;
    }

    // Solution 2
    public int removeDuplicates1(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }
        int i = 0, j = 1;
        while (j < len) {
            if (nums[i] == nums[j]) {
                ++j;
            } else {
                nums[++i] = nums[j++];
            }
        }
        System.out.println(Arrays.toString(nums));
        return i+1;
    }
}
