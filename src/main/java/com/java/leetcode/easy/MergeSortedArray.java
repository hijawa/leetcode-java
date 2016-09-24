package com.java.leetcode.easy;

import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p/>
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n)
 * to hold additional elements from nums2.
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 *
 * @author mti1301
 * @since 2015/6/10.
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4, 5, 6, 0};
        int[] nums2 = {3};
        new MergeSortedArray().merge(nums1, nums1.length - nums2.length, nums2, nums2.length);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        int[] result = new int[n + m];
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                result[i + j] = nums1[i];
                i++;
            } else {
                result[i + j] = nums2[j];
                j++;
            }
        }
        if (i == m) {
            System.arraycopy(nums2, j, result, i + j, n - j);
        }
        if (j == n) {
            System.arraycopy(nums1, i, result, i + j, m - i);
        }
        System.arraycopy(result, 0, nums1, 0, m + n);
        System.out.println(Arrays.toString(result));
    }
}
