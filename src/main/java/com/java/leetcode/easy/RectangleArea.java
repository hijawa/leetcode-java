package com.java.leetcode.easy;

/**
 * @author mti1301
 * @since 2015/6/17.
 */
public class RectangleArea {
    public static void main(String[] args) {
        int[] points = {-1500000001, 0, -1500000000, 1, 1500000000, 0, 1500000001, 1};
//        int[] points = {-3, 0, 3, 4, 0, 0, 1, 1};
//        int[] points = {0, 0, 3, 3, 4, 4, 5, 5};
        System.out.println(computeArea(points[0], points[1], points[2], points[3], points[4], points[5], points[6], points[7]));
    }

    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C - A) * (D - B);
        int area2 = (G - E) * (H - F);
        int totalArea = area1 + area2;

        int intersection;
        int intersectWith = 0;
        int intersectHeight = 0;

        if (A <= E) {
            if (E <= C) {
                intersectWith = Math.min(C, G) - E;
            }
        } else {
            if (A <= G) {
                intersectWith = Math.min(G, C) - A;
            }
        }

        if (B <= F) {
            if (F <= D) {
                intersectHeight = Math.min(D, H) - F;
            }
        } else {
            if (B <= H) {
                intersectHeight = Math.min(D, H) - B;
            }
        }

        intersection = intersectHeight * intersectWith;

        totalArea = totalArea - intersection;
        return totalArea;
    }
}
