package com.java.leetcode.easy;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 *
 * @author Googny
 * @since 2015/6/12.
 */
public class CountPrimes {

    public static void main(String[] args) {
        System.out.println(new CountPrimes().countPrimes(1000000));
    }

    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i < n; ++i) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i < n; ++i) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                ++count;
            }
        }
        return count;
    }
}
