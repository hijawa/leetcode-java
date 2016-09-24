package com.java.leetcode.easy;

import java.util.Arrays;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * <p/>
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * @author mti1301
 * @since 2015/6/10.
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] digits = {1, 2, 3, 4, 8, 9, 1, 2, 3, 4, 8, 9, 1, 2, 3, 4, 8, 9};
        long start = System.currentTimeMillis();
        new PlusOne().plusOne(digits);
        System.out.println(System.currentTimeMillis() - start);
    }

    // Solution 1 常规算法，效率还可以，但不是最高
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        if (len == 0) {
            return new int[0];
        }
        int carry = 0;
        for (int i = len - 1; i >= 0; --i) {
            int sum;
            if (i == len - 1) {
                sum = digits[i] + 1;
            } else {
                sum = digits[i] + carry;
            }
            carry = sum / 10;
            digits[i] = sum % 10;
        }
        if (carry == 0) {
            System.out.println(Arrays.toString(digits));
            return digits;
        } else {
            int[] result = new int[len + 1];
            System.arraycopy(digits, 0, result, 1, len);
            result[0] = carry;
            System.out.println(Arrays.toString(result));
            return result;
        }
    }

    public int[] plusOne1(int[] digits) {
        int len = digits.length;
        if (len == 0) {
            return new int[0];
        }
        int carry = 0;
        for (int i = len - 1; i >= 0; --i) {
            int sum;
            if (i == len - 1) {
                sum = digits[i] + 1;
            } else {
                if (carry == 0) {// 检查进位为0的时候，就停止计算
                    break;
                }
                sum = digits[i] + carry;
            }
            carry = sum / 10;
            digits[i] = sum % 10;
        }
        if (carry == 0) {
            System.out.println(Arrays.toString(digits));
            return digits;
        } else {
            int[] result = new int[len + 1];
            System.arraycopy(digits, 0, result, 1, len);
            result[0] = carry;
            System.out.println(Arrays.toString(result));
            return result;
        }
    }
}
