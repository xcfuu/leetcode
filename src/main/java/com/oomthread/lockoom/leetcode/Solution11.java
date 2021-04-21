package com.oomthread.lockoom.leetcode;

//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，垂直线 i的两个端点
// 分别为(i,ai) 和 (i, 0) 。找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。

//说明：你不能倾斜容器。


public class Solution11 {
    public int maxArea(int[] height) {
        if(height.length<2){
            return 0;
        }
        int sum=0;
        int k=1;
        while(k< height.length){
            int slow=0;
            //int fast=slow+k;
            for(int fast=slow+k;fast<height.length;fast++){
              int  area=k*(height[fast]<height[slow]?height[fast]:height[slow]);
              slow++;
              if (area>sum){
                  sum=area;
              }
            }
            k++;
        }
        return sum;

    }

    //最优解
    //时间复杂度：O(N)O(N)，双指针总计最多遍历整个数组一次。
    //空间复杂度：O(1)O(1)，只需要额外的常数级别的空间。
    public int maxArea1(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            }
            else {
                --r;
            }
        }
        return ans;
    }


}
