package com.oomthread.lockoom.leetcode;

//编写一个函数来查找字符串数组中的最长公共前缀。
public class Solution14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        char[] reString = strs[0].toCharArray();
        int length = reString.length;
        for (int i = 1; i < strs.length; i++) {
            char[] flag = strs[i].toCharArray();
            int size = 0;
            for (int j = 0; j < reString.length && j < length; j++) {
                if (flag.length > j && flag[j] == reString[j]) {
                    size++;
                } else {
                    break;
                }
            }
            if (length > size) {
                length = size;
            }
            if (length == 0) {
                break;
            }

        }
        return strs[0].substring(0,length);
    }

    public static void main(String[] args) {
        String[] strs = {"dog","racecar","car"};
        System.out.println(Solution14.longestCommonPrefix(strs));
    }
}
