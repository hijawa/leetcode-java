package com.java.leetcode.easy;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 * <p/>
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
 * return 964176192 (represented in binary as 00111001011110000010100101000000).
 * <p/>
 * Follow up:
 * If this function is called many times, how would you optimize it?
 *
 * @author mti1301
 * @since 2015/6/9.
 */
public class ReverseBits {
    public int reverseBits(int n) {
        // Integer.reverse() 源代码 看不懂啊
        return Integer.reverse(n);
    }

    public int anotherReverseBits(int n){
        // 还是自己写的比较直观
        int result = 0;
        int cnt = 0;
        while(cnt < 32){
            result <<= 1;
            result += (n & 1);
            n >>>=1;
            cnt++;
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseBits solution = new ReverseBits();
        int a = 1;
        System.out.println(solution.anotherReverseBits(a));
        System.out.println(solution.reverseBits(a));
    }
}
