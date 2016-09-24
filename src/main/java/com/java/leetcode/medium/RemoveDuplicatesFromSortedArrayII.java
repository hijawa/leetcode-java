package com.java.leetcode.medium;

/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * <p/>
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * <p/>
 * Your function should return length = 5,
 * with the first five elements of nums being 1, 1, 2, 2 and 3.
 * It doesn't matter what you leave beyond the new length.
 *
 * @author mti1301
 * @since 2015/6/15.
 */
public class RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
//        int[] nums = {1, 1, 2};
        int[] nums = {1, 1, 1, 2, 3, 3, 3, 4, 4};
        System.out.println(new RemoveDuplicatesFromSortedArrayII().removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return len;
        }
        int i = 0;
        int j = i + 1;
        int interval = 1;

        while (j < len) {
            if (nums[i] == nums[j]) {
                nums[i + 1] = nums[j]; // 挨个儿前移
                interval++;
                j++;
                if (j == len) {
                    i++;
                }
            } else {
                if (interval > 1) { // 间隔大于1的i+2
                    interval = 1;
                    i += 2;
                    nums[i] = nums[j++];
                } else { // 间隔等于1的i+1
                    interval = 1;
                    nums[++i] = nums[j++];
                }
            }
        }
//        System.out.println(Arrays.toString(nums));
        return i + 1;
    }
}
