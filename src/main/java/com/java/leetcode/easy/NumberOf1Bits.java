package com.java.leetcode.easy;

/**
 * Write a function that takes an unsigned integer
 * and returns the number of ’1' bits it has (also known as the Hamming weight).
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011,
 * so the function should return 3.
 *
 * @author mti1301
 * @since 2015/6/9.
 */
public class NumberOf1Bits {

    public static void main(String[] args) {
        System.out.println(new NumberOf1Bits().hammingWeight(2));
    }

    // Solution
    public int hammingWeight(int n) {
        int num = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                num++;
            }
            n >>>= 1;
        }
        return num;
    }

}
