package com.java.leetcode.easy;

/**
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 *
 * @author googny
 * @since 2015/6/17
 */
public class AddBinary {

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("0000", "0000"));
    }

    public String addBinary(String a, String b) {
        int lenA = a.length() - 1;
        int lenB = b.length() - 1;
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        while (lenA != -1 && lenB != -1) {
            int is = (a.charAt(lenA--) - '0') + (b.charAt(lenB--) - '0') + carry;
            if (is >= 2) {
                builder.append(is - 2);
                carry = 1;
            } else {
                builder.append(is);
                carry = 0;
            }
        }

        while (lenA != -1) {
            int is = (a.charAt(lenA--) - '0') + carry;
            if (is >= 2) {
                builder.append(is - 2);
                carry = 1;
            } else {
                builder.append(is);
                carry = 0;
            }
        }
        while (lenB != -1) {
            int is = (b.charAt(lenB--) - '0') + carry;
            if (is >= 2) {
                builder.append(is - 2);
                carry = 1;
            } else {
                builder.append(is);
                carry = 0;
            }
        }
        if (carry == 1) {
            builder.append(carry);
        }
        return builder.reverse().toString();
    }
}
