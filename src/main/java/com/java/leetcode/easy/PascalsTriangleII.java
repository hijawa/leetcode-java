package com.java.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * <p/>
 * For example, given k = 3,
 * Return [1,3,3,1].
 * <p/>
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 *
 * @author mti1301
 * @since 2015/6/10.
 */
public class PascalsTriangleII {

    public static void main(String[] args) {
        System.out.println(new PascalsTriangleII().getRow1(3));
    }

    // Solution 1 使用PascalsTriangle 类中的方法

    public List<Integer> getRow(int rowIndex) {
        rowIndex++;
        List<List<Integer>> result = new ArrayList<>(rowIndex);
        List<Integer> preList = null;
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> list = new ArrayList<>(i);
            if (i == 1) {
                list.add(1);
                preList = list;
                result.add(list);
                continue;
            }
            for (int j = 0; j < i - 1; j++) {
                if (j == 0) {
                    list.add(1);
                } else {
                    list.add(preList.get(j - 1) + preList.get(j));
                }
            }
            list.add(1);
            preList = list;
            result.add(list);
        }
        return result.get(rowIndex - 1);
    }


    // Solution 2 空间限制在O(k) 范围内
    public List<Integer> getRow1(int rowIndex) {
        List<Integer> list = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i <= rowIndex; i++) {
            if (i == 0) {
                list.add(1);
                continue;
            }
            for (int j = i; j > 0; --j) {
                if (j == i) {
                    list.add(1);
                } else {
                    list.set(j, list.get(j - 1) + list.get(j));
                }
            }
        }
        return list;
    }
}
