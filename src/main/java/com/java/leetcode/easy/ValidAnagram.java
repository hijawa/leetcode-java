package com.java.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            char sch = s.charAt(i);
            char tch = t.charAt(i);
            smap.put(sch, smap.get(sch) == null ? 1 : smap.get(sch) + 1);
            tmap.put(tch, tmap.get(tch) == null ? 1 : tmap.get(tch) + 1);
        }

        for (Character ch : smap.keySet()) {
            if (!smap.get(ch).equals(tmap.get(ch))) {
                return false;
            }
        }
        return true;
    }
}
