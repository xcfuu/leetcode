package com.oomthread.lockoom.leetcode;

import java.util.ArrayList;
import java.util.List;

//字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
// 返回一个表示每个字符串片段的长度的列表。
public class Solution763 {
    public static List<Integer> partitionLabels(String S) {
        List<Integer> list = new ArrayList<>();
        if ("".equals(S) || S == null) {
            return list;
        }
        char[] labels = S.toCharArray();
        int length = 0;
        int index1 = 0;
        int index2 = 0;
        while (index1 < labels.length) {//ababcbacadefegdehijhklij
            //char a = labels[index1];
            int flag = labels.length - 1;
            while (index2 < flag && index1 < flag && labels[index1] != labels[flag]) {
                flag--;
            }
            if (flag >= index1) {
                index2 = Math.max(index2, flag);
            }
            if (index2 == index1) {
                list.add(index1 - length + 1);
                index1++;
                length = index1;
            } else {
                index1++;
            }
        }
        return list;
    }

    //官方
    public static List<Integer> partitionLabels1(String S) {
        int[] last = new int[26];
        int length = S.length();
        for (int i = 0; i < length; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0, end = 0;
        for (int i = 0; i < length; i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }



    public static void main(String[] args) {
        System.out.println(Solution763.partitionLabels1("abcdefghamloppolnil")); //2,3,6,10
    }


}
