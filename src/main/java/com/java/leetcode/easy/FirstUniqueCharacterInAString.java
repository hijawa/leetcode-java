package com.java.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haoqi.thq
 * @version $Id: FirstUniqueCharacterInAString.java, v 0.1 2016-09-27 下午11:12 haoqi.thq Exp $
 */
public class FirstUniqueCharacterInAString {
    /**
     * 找到第一个不重复的字符,返回下标
     * @param s 字符串
     * @return 下标
     */
    public int firstUniqChar(String s) {
        if(s == null){
            return -1;
        }
        int len = s.length();
        Map<Character,Integer> amap = new HashMap<>();
        for(int i=len-1;i>-1;--i){
            if(amap.get(s.charAt(i)) == null){
                amap.put(s.charAt(i),1);
            }else{
                amap.put(s.charAt(i),amap.get(s.charAt(i))+1);
            }
        }
        for(int i = 0;i<len;++i){
            if(amap.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}
