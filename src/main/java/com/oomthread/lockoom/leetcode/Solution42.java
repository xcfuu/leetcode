package com.oomthread.lockoom.leetcode;

//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
public class Solution42 {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int p1 = 0;
        int p2 = height.length - 1;
        int trap = 0;
        while (p1 < p2) {
            if (height[p1] <= height[p2]) {
                int flag = p1 + 1;
                while (flag < p2 && height[flag] <= height[p1]) {
                    trap = trap + (height[p1] - height[flag]);
                    flag++;
                }
                p1 = flag;
            } else {
                int flag = p2 - 1;
                while (flag > p1 && height[flag] <= height[p2]) {
                    trap = trap + (height[p2] - height[flag]);
                    flag--;
                }
                p2 = flag;
            }
        }

        return trap;
    }
}
