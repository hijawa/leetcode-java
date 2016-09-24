package com.java.leetcode.easy;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * mti1301
 * 2015/6/9.
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,8,4};
        System.out.println(new RemoveElement().removeElement(nums, 4));
    }

    /**
     * Solution 逐步将要剩余元素依次前移
     * val=4,nums = {4,5,6,7,8,4}
     * i=0,count=1  {5,5,6,7,8,4}
     * i=1,count=1  {5,6,6,7,8,4}
     * i=2,count=1  {5,6,7,7,8,4}
     * i=3,count=1  {5,6,7,8,8,4}
     * i=4,count=1  {5,6,7,8,8,4}
     */
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int count = 0; // 计数要删除的元素个数
        for (int i = 0; i + count < length; ++i) {
            int elem = nums[i + count];
            if (elem == val) {
                ++count;
                if (i + count >= length) {//所有元素都是要删除的
                    break;
                }
                nums[i] = nums[i + count];
                i--;
            } else {
                if (count > 0) {
                    nums[i] = nums[i + count];
                }
            }
        }
        return length - count;
    }
}
