package com.java.leetcode.medium;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * <p/>
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 *
 * @author mti1301
 * @since 2015/6/26.
 */
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();
        List<String> result = new LinkedList<String>();
        LinkedList<Integer> stack = new LinkedList<Integer>();
        stack.push(nums[0]);
        int pre = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            int ele = nums[i];
            if (ele == pre + 1) {
                pre = ele;
                continue;
            } else {
                int start = stack.pop();
                if (start == pre) {
                    result.add("" + start);
                } else {
                    result.add(start + "->" + pre);
                }
                pre = ele;
                stack.push(pre);
            }
        }
        if (stack.size() > 0) {
            int start = stack.pop();
            if (start == pre) {
                result.add("" + start);
            } else {
                result.add(start + "->" + pre);
            }
        }
        return result;
    }


    // 感觉使用栈 有点多余
    public List<String> summaryRanges1(int[] nums) {
        if (nums == null || nums.length == 0) return Collections.emptyList();
        List<String> result = new LinkedList<String>();
        int start = nums[0];
        int pre = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            int ele = nums[i];
            if (ele == pre + 1) {
                pre = ele;
                continue;
            } else {
                if (start == pre) {
                    result.add("" + start);
                } else {
                    result.add(start + "->" + pre);
                }
                pre = ele;
                start = pre;
            }
        }
        if (start == pre) {
            result.add("" + start);
        } else {
            result.add(start + "->" + pre);
        }
        return result;
    }
}
