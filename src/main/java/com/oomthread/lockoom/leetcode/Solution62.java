package com.oomthread.lockoom.leetcode;

// 不同路径
//一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
//
//机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
//
//问总共有多少条不同的路径？
public class Solution62 {
    int[][] dp=null;
    public  int uniquePaths(int m, int n) {
        if(m<2||n<2){
            return 1;
        }
        dp= new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0]=1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i]=1;
        }
        m--;
        n--;
        return returnRou(m, n , dp);
    }

    public  int returnRou(int m, int n, int[][] dp) {
        if (m == 0 && n == 1) {
            return 1;
        }
        if (m == 1 && n == 0) {
            return 1;
        }
        int sum = dp[m][n];
        if (sum == 0) {
            if (n == 0 && m > 1) {
                sum = returnRou(m-1, n, dp);
            } else if (m == 0 && n > 1) {
                sum = returnRou(m, n-1, dp);
            } else {
                sum = returnRou(m - 1,n, dp) + returnRou(m, n-1, dp);
            }
        }
        dp[m][n]=sum;
        return sum;
    }

    public static int uniquePaths1(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; ++i) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }

    //1916797311
    public static void main(String[] args) {
        //System.out.println(Solution62.uniquePaths(51, 9));
    }
}
