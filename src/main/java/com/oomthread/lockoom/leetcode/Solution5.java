package com.oomthread.lockoom.leetcode;

//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
public class Solution5 {
    public static String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) {
            return s;
        }
        boolean[][] pon = new boolean[n][n];
        String res=new String();
        for (int len = 0; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                if (len == 0) {
                    pon[i][j] = true;
                } else if (len == 1) {
                    pon[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    pon[i][j] = (s.charAt(i) == s.charAt(j) && pon[i + 1][j - 1]);
                }
                if (pon[i][j] && len + 1 >res.length()){
                    res=s.substring(i,j+1);
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Solution5.longestPalindrome("cdbsbdkj"));
    }
}
