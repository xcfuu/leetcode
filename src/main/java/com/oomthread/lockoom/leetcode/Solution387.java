package com.oomthread.lockoom.leetcode;


import java.util.HashMap;
import java.util.Map;

//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//提示：你可以假定该字符串只包含小写字母。
public class Solution387 {
    //me
    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char cs : s.toCharArray()) {
            map.put(cs, map.getOrDefault(cs, 0) + 1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        System.out.println(Solution387.firstUniqChar("loveleetcode"));
        System.out.println(Solution387.firstUniqChar("aaaaaa"));
        System.out.println(Solution387.firstUniqChar(""));
        System.out.println(Solution387.firstUniqChar("a"));
        System.out.println(Solution387.firstUniqChar("aadadaad"));
    }
}
