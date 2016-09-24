package com.java.leetcode.easy;

/**
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * <p/>
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three",
 * it is the fifth second-level revision of the second first-level revision.
 * <p/>
 * Here is an example of version numbers ordering:
 * <p/>
 * 0.1 < 1.1 < 1.2 < 13.37
 *
 * @author googny
 * @since 2015/6/22
 */
public class CompareVersionNumbers {
    /**
     * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
     * 考虑以下三种情况：
     * 一、字符串中没有‘.’号，例如 1 和 1.0
     * 二、字符串中不止一个‘.’号 例如 1.0 和 1.0.0
     * 三、字符串中一个版本号前有0，例如 1.01.02 和 1.1.2
     *
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {
        String[] verSplice1 = version1.contains(".") ? version1.split("\\.") : new String[]{version1};
        String[] verSplice2 = version2.contains(".") ? version2.split("\\.") : new String[]{version2};

        int i = 0;
        while (i < Math.min(verSplice1.length, verSplice2.length)) {
            if (Integer.parseInt(verSplice1[i]) > Integer.parseInt(verSplice2[i])) {
                return 1;
            } else if (Integer.parseInt(verSplice1[i]) < Integer.parseInt(verSplice2[i])) {
                return -1;
            }
            ++i;
        }
        while (i < verSplice1.length) {
            if (Integer.parseInt(verSplice1[i++]) != 0) {
                return 1;
            }
        }

        while (i < verSplice2.length) {
            if (Integer.parseInt(verSplice2[i++]) != 0) {
                return -1;
            }
        }
        return 0;
    }
}
