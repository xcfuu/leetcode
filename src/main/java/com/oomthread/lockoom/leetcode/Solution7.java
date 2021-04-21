package com.oomthread.lockoom.leetcode;

//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
public class Solution7 {
    public static int reverse(int x) {
        int reverse = 0;
        while (x != 0) {
            int p = x % 10;
            x = x / 10;
            if ((reverse == Integer.MAX_VALUE / 10 && p > 7) || reverse > Integer.MAX_VALUE / 10) return 0;
            if ((reverse == Integer.MIN_VALUE / 10 && p < -8) || reverse < Integer.MIN_VALUE / 10) return 0;
            reverse = reverse * 10 + p;
        }
        return reverse;
    }

    public static void main(String[] args) {
        System.out.println(Solution7.reverse(321));
    }
}
