package com.java.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * mti1301
 * 2015/6/9.
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(new PascalsTriangle().generate1(5));
        System.out.println(System.currentTimeMillis() - start);
    }

    // Solution 1
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        for (int i = 1; i <= numRows; ++i) {
            List<Integer> list = new ArrayList<>(i);
            list.add(1);
            result.add(list);
        }
        if (numRows == 1) {
            return result;
        }
        for (int i = 1; i < numRows; ++i) {
            List<Integer> preList = result.get(i - 1);
            List<Integer> list = result.get(i);
            for (int j = 1; j < i; ++j) {
                list.add(preList.get(j - 1) + preList.get(j));
            }
            list.add(1);
        }
        return result;
    }

    // Solution 2
    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        List<Integer> preList = null;
        for (int i = 1; i <= numRows; i++) {
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
        return result;
    }
}
