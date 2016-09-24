package com.java.leetcode.easy;

/**
 * Given an integer, write a function to determine if it is a power of two.
 *
 * @author mti1301
 * @since 2015/7/7.
 */
public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        return ((n - 1) & n) == 0;
    }
}
