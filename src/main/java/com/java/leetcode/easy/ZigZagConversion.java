package com.java.leetcode.easy;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * <p/>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p/>
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 *
 * @author mti1301
 * @since 2015/6/23.
 */
public class ZigZagConversion {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(new ZigZagConversion().convert(s, 3));
    }

    public String convert(String s, int numRows) {
        int len = s.length();
        int zagLen = (int) Math.ceil(len / numRows);

        StringBuffer buffer = new StringBuffer();

        for (int j = 0; j < numRows; j++) {
            for (int i = 0; i < zagLen; i++) {
                buffer.append(s.charAt(i * numRows + j));
            }
        }
        return buffer.toString();
    }
}
