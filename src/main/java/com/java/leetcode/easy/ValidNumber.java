package com.java.leetcode.easy;

/**
 * @author mti1301
 * @since 2015/8/5.
 */
public class ValidNumber {

    public static void main(String[] args) {
        System.out.println(new ValidNumber().isNumber("..2"));
    }

    public boolean isNumber(String s) {
        int len = s.length();
        int i = 0;
        while (i < len && Character.isWhitespace(s.charAt(i))) i++;

        if (i < len && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;

        boolean isNumeric = false;
        while (i < len && Character.isDigit(s.charAt(i))) {
            i++;
            isNumeric = true;
        }
        if (i < len && s.charAt(i) == '.') {
            i++;
            while (i < len && Character.isDigit(s.charAt(i))) {
                i++;
                isNumeric = true;
            }
        }
        if (isNumeric && i < len && s.charAt(i) == 'e') {
            i++;
            isNumeric = false;
            if (i < len && (s.charAt(i) == '+' || s.charAt(i) == '-')) i++;
            while (i < len && Character.isDigit(s.charAt(i))) {
                i++;
                isNumeric = true;
            }
        }
        while (i < len && Character.isWhitespace(s.charAt(i))) i++;
        return isNumeric && i == len;
    }
}
