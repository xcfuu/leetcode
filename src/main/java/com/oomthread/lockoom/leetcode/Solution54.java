package com.oomthread.lockoom.leetcode;

import java.util.ArrayList;
import java.util.List;

//螺旋矩阵
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//输出: [1,2,3,6,9,8,7,4,5]
public class Solution54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = 0;
        List<Integer> res = new ArrayList<>();
        if (m > 0) {
            n = matrix[0].length;
        } else {
            return res;
        }
        int length = m * n;

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int x = 0;
        int y = 0;
        while (length > 1) {
            //行
            int row = y;
            //列
            int col = x;
            for (int i = 0; i < directions.length; i++) {
                int step;
                if (i == 0 || i == 2) {
                    step = n - 1;
                } else {
                    step = m - 1;

                }
                while (length > 0 && step > 0) {
                    res.add(matrix[row][col]);
                    row = row + directions[i][0];
                    col = col + directions[i][1];
                    length--;
                    step--;
                }
            }
            m = m - 2;
            n = n - 2;
            y++;
            x++;
        }
        if (m == 1 && n == 1) {
            res.add(matrix[y][x]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] directions = {{1,2,3,4}};
        System.out.println(Solution54.spiralOrder(directions));
    }
}
