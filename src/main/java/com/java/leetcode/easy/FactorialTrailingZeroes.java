package com.java.leetcode.easy;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * <p>
 * Note: Your solution should be in logarithmic time complexity.
 *
 * @author googny
 * @since 2015/6/18
 */
public class FactorialTrailingZeroes {

    public static void main(String[] args) {
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(100));
    }

    // 计算1~n之间所有的能被5整除的数字个数，如果一个数能被5循环整除多次，则加上循环次数。
    public int trailingZeroes(int n) {
        int sum = 0;
        int tmp;
        while (n / 5 > 0) {
            tmp = n / 5;
            sum += tmp;
            n = tmp;
        }
        return sum;
    }
}
