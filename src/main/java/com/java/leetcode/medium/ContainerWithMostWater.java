package com.java.leetcode.medium;

/**
 * @author haoqi.thq
 * @version $Id: ContainerWithMostWater, v 0.1 2016/9/24 14:44 haoqi.thq Exp $
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int low = 0;
        int high = height.length - 1;

        int maxArea = 0;

        while (low < high) {
            int area = (high - low) * Math.min(height[low], height[high]);
            maxArea = Math.max(maxArea, area);
            /*
            初始阶段x轴方向上应该是最长的，以后要依次递减，所以无论low后移还是high前移，x轴上距离是相等的。
            因此比较low和high指向值的大小，值小的一边先移动，才找到更大的值的可能，否则y轴方向上一直是小值
             */
//            if (height[low] > height[high]) {
//                high--;
//            } else {
//                low++;
//            }

            /*
            参考网上一些同志的做法，如果发现移动后（前移或后移）的元素比前一个（前/后）元素更小的话，
            不用计算area的值（面积肯定更小（因为x轴距离变小，值也变小）），继续移动，以期发现更大的值。
             */
            if (height[low] > height[high]) {
                do {
                    high--;
                }
                while (low < high && height[high + 1] > height[high]);
            } else {
                do {
                    low++;
                } while (low < high && height[low - 1] > height[low]);
            }
        }
        return maxArea;
    }
}
