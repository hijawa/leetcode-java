package com.java.leetcode.easy;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * <p>
 * For example:
 * <p>
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 *
 * @author googny
 * @since 2015/6/17
 */
public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnNumber().titleToNumber("Z"));
    }

    public int titleToNumber(String s) {
        s = s.toUpperCase();
        int len = s.length() - 1;
        int i = 0;
        int colNum = 0;
        while (len != -1) {
            char ch = s.charAt(len--);
            colNum += (ch - 'A' + 1) * Math.pow(26, i++);
        }
        return colNum;
    }
}
