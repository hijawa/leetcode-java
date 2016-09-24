package com.java.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Write an algorithm to determine if a number is "happy".
 * <p/>
 * A happy number is a number defined by the following process: Starting with any positive integer,
 * replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 * <p/>
 * Example: 19 is a happy number
 * <p/>
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 *
 * @author mti1301
 * @since 2015/6/12.
 */
public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(100000000));
    }

    public boolean isHappy(int n) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int sum;
        while (!hashMap.containsKey(n)) {
            sum = happy(n);
            if (sum == 1) {
                return true;
            } else {
                hashMap.put(n, sum);
            }
            n = sum;
        }
        return false;
    }

    private int happy(int n) {
        int sum = 0;
        while (n != 0) {
            int i = n % 10;
            sum += i * i;
            n /= 10;
        }
        return sum;
    }
}
