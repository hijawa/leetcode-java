package com.java.leetcode.easy;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * <p/>
 * For example:
 * <p/>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 *
 * @author mti1301
 * @since 2015/6/17.
 */
public class ExcelSheetColumnTitle {
    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(25));
    }

    public String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();
        n = n - 1;
        while (n != -1) {
            int remainder = n % 26;
            builder.append((char) ('A' + remainder));
            n = n / 26 - 1;
        }
        return builder.reverse().toString();
    }
}
