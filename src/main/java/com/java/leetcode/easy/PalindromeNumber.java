package com.java.leetcode.easy;

/**
 * @author haoqi.thq
 * @version $Id: PalindromeNumber, v 0.1 2016/9/24 14:25 haoqi.thq Exp $
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int len = 1;
        int tmp = x;
        while ((tmp = (tmp / 10)) != 0) {
            len++;
        }
        for (int i = 0; i < len / 2; i++) {
            int left = (x / (int) Math.pow(10, i)) % 10;
            int right = (x / (int) Math.pow(10, len - i - 1)) % 10;
            if (left != right)
                return false;
        }
        return true;
    }
}
