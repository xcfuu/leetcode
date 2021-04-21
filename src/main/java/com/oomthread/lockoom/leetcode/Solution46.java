package com.oomthread.lockoom.leetcode;

import java.util.*;

//[1,2,3]
public class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int size = nums.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(nums[i]);
        }
        getAllList(res, list, new ArrayList<>(), size);
        return res;
    }

    private void getAllList(List<List<Integer>> res, List<Integer> list, ArrayList<Integer> result, int size) {
        if (result.size() == size) {
            List<Integer> newList = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                newList.add(result.get(i));
            }
            res.add(newList);
        }
        for (int i = 0; i < list.size(); i++) {
            List<Integer> flagList=new ArrayList<>(list.size());
            for (int j = 0; j < list.size(); j++) {
                if(j!=i){
                    flagList.add(list.get(j));
                }
            }
            result.add(list.get(i));
            getAllList(res,flagList,result,size);
            result.remove(result.size()-1);
        }
    }

    /*public static void main(String[] args) {


        //Integer ins=new Integer(1);
        Set<String> ins1=new HashSet<>();
        String a="a";
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            ins1.add(a);
            a=a+"a";
            System.out.println(a);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }*/
    public static void main(String[] args) {
        int a=1;
        int b=4;
        System.out.println(b<<1);

        String s="EBiATOsyQ829H6cyNNarPw";
        System.out.println(s.substring(0,16));
    }
}
