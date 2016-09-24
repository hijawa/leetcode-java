package com.java.leetcode.easy;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 * <p/>
 * If the last word does not exist, return 0.
 * <p/>
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * <p/>
 * For example,
 * Given s = "Hello World",
 * return 5.
 *
 * @author mti1301
 * @since 2015/6/23.
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().lengthOfLastWord(" "));
        System.out.println(new LengthOfLastWord().lengthOfLastWord("Hello  World"));
        System.out.println(new LengthOfLastWord().lengthOfLastWord("Hello   World  "));
        System.out.println(new LengthOfLastWord().lengthOfLastWord("Hello   World  "));
    }

    public int lengthOfLastWord(String s) {
        s = s.trim();
        int len = s.length();
        int result = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                ++result;
            } else {
                break;
            }
        }
        return result;
    }
}
