package com.java.leetcode.easy;

/**
 * @author haoqi.thq
 * @version $Id: StringToInteger, v 0.1 2016/9/24 14:27 haoqi.thq Exp $
 */
public class StringToInteger {
    /**
     * 解题思路：
     * 这道题乍看起来很简单，但是一不小心就会出错。
     * ① 首先判断字符串是不是为空，或者去空格后长度是不是为0
     * ② 如果满足第一步，则首先根据首字符判断转换后的数字正负情况
     * ③ 扫描字符串，遇到非数字字符则返回已经转换的值
     * ④ 遇到数字字符，分情况（正负）判断继续转换会不会造成整型溢出。
     * ⑤ 溢出则返回同一方向上的极值，否则继续扫描
     *
     * @param str 待转换的字符串
     * @return 转换后的数字
     */
    public int atoi(String str) {
        if (str == null || str.trim().length() == 0) {
            return 0;
        }

        str = str.trim();
        int len = str.length();
        char sign = '+';
        int num = 0;

        for (int i = 0; i < len; ++i) {
            if (i == 0 && (str.charAt(0) == '+' || str.charAt(0) == '-')) {
                sign = str.charAt(0);
                continue;
            }

            if (Character.isDigit(str.charAt(i))) {
                int tmp = str.charAt(i) - '0';

                if (sign == '+' && num > (Integer.MAX_VALUE - tmp) / 10) {
                    return Integer.MAX_VALUE;
                }
                if (sign == '-' && -num < (Integer.MIN_VALUE + tmp) / 10) {
                    return Integer.MIN_VALUE;
                }
                num = num * 10 + tmp;
            } else {
                break;
            }
        }
        return sign == '+' ? num : -num;
    }
}
