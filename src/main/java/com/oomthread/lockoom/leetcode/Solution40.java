package com.oomthread.lockoom.leetcode;


import java.util.*;

public class Solution40 {
    public List<List<Integer>> combinationSum21(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        getCombtionList1(res, new ArrayList<>(), candidates, 0, target, 0);
        return res;
    }

    private void getCombtionList1(List<List<Integer>> res, List<Integer> integers, int[] candidates, int index, int target, int curr) {
        for (int i = index; i < candidates.length; i++) {
            if (curr + candidates[i] == target) {
                integers.add(candidates[i]);
                List<Integer> newList = new ArrayList<>();
                for (int j = 0; j < integers.size(); j++) {
                    newList.add(integers.get(j));
                }
                Collections.sort(newList);
                boolean flag = true;
                for (int m = 0; m < res.size(); m++) {
                    List<Integer> list = res.get(m);
                    if (list.size() == newList.size()) {
                        flag = false;
                        for (int k = 0; k < list.size(); k++) {
                            if (list.get(k) != newList.get(k)) {
                                flag = true;
                                break;
                            }
                        }
                    }
                    if (!flag) {
                        break;
                    }
                }
                if (flag) {
                    res.add(newList);
                }
                integers.remove(integers.size() - 1);
            } else if ((curr + candidates[i]) < target) {
                integers.add(candidates[i]);
                getCombtionList1(res, integers, candidates, i + 1, target, curr + candidates[i]);
                integers.remove(integers.size() - 1);
            }
        }
    }
    //优化
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        getCombtionList(res, new ArrayList<>(), candidates, 0, target, 0);
        return res;
    }

    private void getCombtionList(List<List<Integer>> res, List<Integer> integers, int[] candidates, int index, int target, int curr) {
        List<Integer> isSame=new ArrayList<>();
        for (int i = index; i < candidates.length; i++) {
            if (curr + candidates[i] == target) {
                if(!iscontains(isSame,candidates[i])) {
                    isSame.add(candidates[i]);
                    integers.add(candidates[i]);
                    List<Integer> newList = new ArrayList<>();
                    for (int j = 0; j < integers.size(); j++) {
                        newList.add(integers.get(j));
                    }
                    res.add(newList);
                    integers.remove(integers.size() - 1);
                }
            } else if ((curr + candidates[i]) < target) {
                if(!iscontains(isSame,candidates[i])){
                    isSame.add(candidates[i]);
                    integers.add(candidates[i]);
                    getCombtionList(res, integers, candidates, i + 1, target, curr + candidates[i]);
                    integers.remove(integers.size() - 1);
                }

            }
        }
    }

    private boolean iscontains(List<Integer> isSame, int candidate) {
        for (int i = 0; i < isSame.size(); i++) {
            if(isSame.get(i).intValue()==candidate){
                return true;
            }
        }
        return false;
    }


}
