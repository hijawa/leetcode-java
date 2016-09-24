package com.java.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character
 * while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 * <p/>
 * For example,
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 * <p/>
 * Note:
 * You may assume both s and t have the same length.
 *
 * @author mti1301
 * @since 2015/6/11.
 */
public class IsomorphicStrings {

    public static void main(String[] args) {
        System.out.println(new IsomorphicStrings().isIsomorphic("ab", "aa"));

    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> sMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            Character sch = s.charAt(i);
            Character tch = t.charAt(i);
            Character sValue = sMap.get(sch);
            Character tValue = tMap.get(tch);
            if (sValue == null && tValue == null) {
                sMap.put(sch, tch);
                tMap.put(tch, sch);
            } else if (sValue != tch || tValue != sch) {
                return false;
            }
        }
        return true;
    }
}
