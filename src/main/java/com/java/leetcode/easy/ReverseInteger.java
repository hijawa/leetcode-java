package com.java.leetcode.easy;

/**
 * @author haoqi.thq
 * @version $Id: ReverseInteger, v 0.1 2016/9/24 14:25 haoqi.thq Exp $
 */
public class ReverseInteger {

    public  int reverse(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        int offset = 0;
        int len = chars.length - 1;
        if (chars[0] == '-') {
            offset = 1;
        }
        for (int i = 0; i < (len + 1) / 2; i++) {
            char ch = chars[i + offset];
            chars[i + offset] = chars[len - i];
            chars[len - i] = ch;
        }
        int result;
        try {
            result = Integer.valueOf(new String(chars));
        } catch (NumberFormatException nfe) {
            result = 0;
        }
        return result;
    }

}
