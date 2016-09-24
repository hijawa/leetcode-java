package com.java.leetcode.medium;

/**
 * Given an input string, reverse the string word by word.
 * <p/>
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 *
 * @author mti1301
 * @since 2015/6/29.
 */
public class ReverseWordsInAString {

    public static void main(String[] args) {
        String str = "The  sky  is  blue ";
        System.out.println(new ReverseWordsInAString().reverseWords(str));
    }

    // 利用StringBuffer 从后往前遍历字符串
    public String reverseWords(String s) {
        s = s.trim();
        StringBuffer buffer = new StringBuffer();
        int len = s.length();
        int j = 0;
        boolean space = false;
        for (int i = len - 1; i >= 0; --i) {
            char ch = s.charAt(i);
            if (!Character.isSpaceChar(ch)) {
                ++j;
                if (space) {
                    space = false;
                }
            } else {
                buffer.append(s.substring(i + 1, i + j + 1));
                if (!space) {
                    buffer.append(ch);
                    space = true;
                }
                j = 0;
            }
        }
        buffer.append(s.substring(0, j));
        return buffer.toString();
    }


    // 利用正则表达式直接将字符串分割成Word 数组
    public String reverseWords_withRegex(String s) {
        String[] parts = s.trim().split("\\s+");
        StringBuffer out = new StringBuffer();
        if (parts.length > 0) {
            for (int i = parts.length - 1; i > 0; i--) {
                out.append(parts[i] + " ");
            }
            out.append(parts[0] + " ");
        }
        return out.toString();
    }
}
