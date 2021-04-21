package com.oomthread.lockoom.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//给出一个区间的集合，请合并所有重叠的区间。
public class Solution56 {
    public static int[][] merge(int[][] intervals) {
        if(intervals.length <= 1){
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

        int[] currInterval = intervals[0];
        List<int[]> resArr = new ArrayList<>();
        resArr.add(currInterval);

        for(int[] interval: intervals){
            int currEnd = currInterval[1];

            int nextBegin = interval[0];
            int nextEnd = interval[1];

            if(currEnd >= nextBegin){
                currInterval[1] = Math.max(currEnd, nextEnd);
            } else{
                currInterval = interval;
                resArr.add(currInterval);
            }
        }

        return resArr.toArray(new int[resArr.size()][]);
    }


    public static void main(String[] args) {

        int [][] arr=new int[][]{{2,5},{1,3},{7,9},{4,10}};
        Arrays.sort(arr, Comparator.comparingInt(arr1 -> arr1[0]));
        System.out.println(arr[0]);
        //System.out.println(Solution56.merge(arr));
        System.out.println(arr);
    }
}
