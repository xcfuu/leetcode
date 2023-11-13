package com.oomthread.lockoom.leetcode;

import java.util.Arrays;

/**
 * @Author xuechaofu
 * @Date 2023-10-30 16:04
 **/
public class Solution415 {
    public String addStrings(String num1, String num2) {

        char[] chars1 = num1.toCharArray();

        char[] chars2 = num2.toCharArray();

        int size1 = chars1.length;

        int size2 = chars2.length;

        int[] n1 = new int[size1];
        int[] n2 = new int[size2];

        for (int i = 0; i < size1; i++) {
            n1[i] = (int) chars1[size1 - 1 - i] - (int) '0';
        }
        for (int i = 0; i < size2; i++) {
            n2[i] = (int) chars2[size2 - 1 - i] - (int) '0';
        }

        int size = Math.max(size1, size2) + 1;

        int[] newArr = new int[size];

        int next = 0;

        for (int i = 0; i < size; i++) {
            int val1 = 0;
            int val2 = 0;
            if (i < size1) {
                val1 = n1[i];
            }

            if (i < size2) {
                val2 = n2[i];
            }

            int sum = next + val1 + val2;
            newArr[i] = sum % 10;
            next = sum / 10;
        }


        StringBuilder re = new StringBuilder();

        for (int i = 0; i < size; i++) {
            if (size > 1 && i == 0 && newArr[size - 1 - i] == 0) {
                continue;
            }
            re.append(newArr[size - 1 - i]);
        }

        return re.toString();

    }

    public static void main(String[] args) {
        Solution415 solution415 = new Solution415();
        solution415.addStrings("1", "9");
    }

}
