package com.oomthread.lockoom.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
//给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
public class Solution17 {
    public List<String> letterCombinations(String digits) {
        Map<String,char[]> map=new HashMap<>();
        List<String> res=new ArrayList<>();
        map.put("2",new char[]{'a','b','c'});
        map.put("3",new char[]{'d','e','f'});
        map.put("4",new char[]{'g','h','i'});
        map.put("5",new char[]{'j','k','l'});
        map.put("6",new char[]{'m','n','o'});
        map.put("7",new char[]{'p','q','r','s'});
        map.put("8",new char[]{'t','u','v'});
        map.put("9",new char[]{'w','x','y','z'});
        if(digits==null||digits.length()==0){
            return res;
        }
        //char[] digit=digits.toCharArray();
        this.getReturn(digits,map,res,new StringBuilder());
        return res;
    }

    private void getReturn(String digits, Map<String,char[]> map, List<String> res, StringBuilder s) {
        if (digits.length()==0){
            res.add(s.toString());
            return;
        }
        char[] chars = map.get(digits.substring(0, 1));
        digits=digits.substring(1);
        for (int i = 0; i < chars.length; i++) {
            s.append(chars[i]);
            getReturn(digits,map,res,s);
            s.deleteCharAt(s.length()-1);
        }
    }

    public static void main(String[] args) {
        Solution17 solution17=new Solution17();
        solution17.letterCombinations("23");
    }
}
