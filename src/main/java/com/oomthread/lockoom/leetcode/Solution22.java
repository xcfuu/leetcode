package com.oomthread.lockoom.leetcode;

import java.util.ArrayList;
import java.util.List;

//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<>();

        getValAll(res,new StringBuilder(),0,0,n);
        return res;
    }

    private void getValAll(List<String> res, StringBuilder  curr, int open, int close, int n) {
        if(open+close==2*n){
            res.add(String.valueOf(curr));
        }
        if(open<n){
            curr.append('(');
            getValAll(res,curr,open+1,close,n);
            curr.deleteCharAt(curr.length()-1);

        }
        if(close<open){
            curr.append(')');
            getValAll(res,curr,open,close+1,n);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
