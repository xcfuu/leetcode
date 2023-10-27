package com.oomthread.lockoom.leetcode;

/**
 * @Author xuechaofu
 * @Date 2023-10-18 18:28
 **/
public class Solution200 {
    public int numIslands(char[][] grid) {
        int re = grid.length;
        int te = grid[0].length;

        int sum = 0;
        for (int i = 0; i < re; i++) {
            for (int j = 0; j < te; j++) {
                if (grid[i][j] == '1') {
                    ++sum;
                    dfs(grid, i, j, re, te);
                }
            }
        }

        return sum;
    }

    private void dfs(char[][] grid, int i, int j, int re, int te) {

        if (i < 0 || j < 0 || i >= re || j >= te || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid,i-1,j,re,te);
        dfs(grid,i+1,j,re,te);
        dfs(grid,i,j-1,re,te);
        dfs(grid,i,j+1,re,te);

    }


}
