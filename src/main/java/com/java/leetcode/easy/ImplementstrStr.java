package com.java.leetcode.easy;

/**
 * Implement strStr().
 * <p/>
 * Returns the index of the first occurrence of needle in haystack,
 * or -1 if needle is not part of haystack.
 *
 * @author googny
 * @since 2015/6/14
 */
public class ImplementstrStr {

    public static void main(String[] args) {
        String haystack = "aba";
        String needle = "ba";
        System.out.println(new ImplementstrStr().strStr(haystack, needle));
    }


    public int strStr(String haystack, String needle) {
        int hsLen = haystack.length();
        int nLen = needle.length();
        int firstOcc = -1;

        for (int i = 0; i <= hsLen - nLen; i++) {
            int j = 0;
            while (j < nLen) {
                if (haystack.charAt(i) != needle.charAt(j)) {
                    break;
                }
                i++;
                j++;
            }
            if (j == nLen) {
                firstOcc = i - nLen;
                return firstOcc;
            } else {
                // 退回 j 步
                i -= j;
            }
        }
        return firstOcc;
    }

    // 优雅的解法
    public int strStr_good(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }
}
