package com.java.leetcode.easy;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * <p/>
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * <p/>
 * Note: The sequence of integers will be represented as a string.
 *
 * @author googny
 * @since 2015/6/22
 */
public class CountandSay {
    public static void main(String[] args) {
        System.out.println(new CountandSay().countAndSay(5));
    }

    /**
     * 这是一种理解题意错误的解决方案，列在这里只是说明当初为什么做错。
     * 我当初理解是将n代表的数字，用字符串表示出来，比如：
     * 1->1个1->11
     * 2->1个2->12
     * ... ...
     * 12334->1个1，1个2，2个3，1个4->11122314
     *
     * @param n
     * @return
     */
    public String countAndSayWrong(int n) {
        String nStr = new Integer(n).toString();
        int count = 1;
        StringBuffer buffer = new StringBuffer();
        int len = nStr.length();
        char mark = nStr.charAt(0);
        for (int i = 1; i < len; ++i) {
            if (mark == nStr.charAt(i)) {
                ++count;
            } else {
                buffer.append(count).append(mark);
                count = 1;
                mark = nStr.charAt(i);
            }
        }
        buffer.append(count).append(mark);
        return buffer.toString();
    }

    /**
     * 正确的解法
     * 1->"1"
     * 2->"11"(2 其实是对1 read off 的字符串的解释)
     * 3->"21"(以此类推)
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n < 0) return "";
        if (n == 1) return "1";
        StringBuffer buffer = new StringBuffer();
        String nStr = "1";
        int count = 1;
        while (n > 1) {
            int len = nStr.length();
            char mark = nStr.charAt(0);
            for (int i = 1; i < len; ++i) {
                if (mark == nStr.charAt(i)) {
                    ++count;
                } else {
                    buffer.append(count).append(mark);
                    count = 1;
                    mark = nStr.charAt(i);
                }
            }
            nStr = buffer.append(count).append(mark).toString();
            buffer.setLength(0);
            count = 1;
            --n;
        }
        return nStr;
    }
}
