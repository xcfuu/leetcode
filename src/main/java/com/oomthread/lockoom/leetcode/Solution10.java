package com.oomthread.lockoom.leetcode;

//aaaaabikl
//a.*bi.kl

//TODO 此题可用动态规划与回溯法

public class Solution10 {
    public boolean isMatch(String s, String p) {
        //如果正则串p为空字符串s也为空这匹配成功，如果正则串p为空但是s不是空则说明匹配失败
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        //判断s和p的首字符是否匹配，注意要先判断s不为空
        boolean eq = !s.isEmpty()&&(s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        //如果p的第一个元素的下一个元素是*
        // 则分别对两种情况进行判断 1、匹配字母去除s首字母 2、未匹配字母去除*
        if (p.length() > 1 && p.charAt(1) == '*') {
            return (eq&&isMatch(s.substring(1), p)) || isMatch(s, p.substring(2));
        } else if (eq) {
            return isMatch(s.substring(1), p.substring(1));
        } else {
            return false;
        }
    }
}
