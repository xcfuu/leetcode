package com.oomthread.lockoom.leetcode;

//将一个给定字符串根据给定的行数，以从上往下、从左到右进行Z 字形排列。
//
//比如输入字符串为 "LEETCODEISHIRING"行数为 3 时，排列如下：
//
//L   C   I   R
//E T O E S I I G
//E   D   H   N
//之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

import java.util.ArrayList;
import java.util.List;

public class Solution6 {
    public static String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        if (chars.length <= numRows || numRows == 1) {
            return s;
        }
        int num = chars.length / (2 * numRows - 2);
        int less = chars.length % (2 * numRows - 2);
        if (less > 0) {
            num++;
        }
        //char[] reschars=new char[chars.length];
        StringBuilder returnString = new StringBuilder(chars.length);

        //循环每行输出
        for (int i = 0; i < numRows; i++) {
            //转换队形后以
            //*
            //* *
            //**
            //*
            //这个分割队列输出;注意除了头尾两行都是输出两个字母
            for (int col = 0; col < num; col++) {
                int index = col * (2 * numRows - 2) + i;
                int index2 = (col + 1) * (2 * numRows-2) - i;
                if (index < chars.length) {
                    //System.out.print(chars[col*(2*numRows-2)+i]);
                    returnString.append(chars[index]);
                    if (i != 0 && i != numRows - 1 && index2 < chars.length) {
                        returnString.append(chars[index2]);
                    }

                }

            }
        }

        return returnString.toString();
    }


    public static String convert1(String s, int numRows) {
        if(numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1) flag = - flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        return res.toString();
    }


    public static void main(String[] args) {
        System.out.println(Solution6.convert1("LEETCOD", 3));
        System.out.println("LCETOED");
    }
}
