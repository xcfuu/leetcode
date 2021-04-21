package com.oomthread.lockoom.leetcode;

//gas  = [1,2,3,4,5]
//cost = [3,4,5,1,2]
public class Solution134 {

    //n2
    public  int canCompleteCircuit1(int[] gas, int[] cost) {
        int m = gas.length;
        int[] flag = new int[gas.length];
        int sum = 0;
        int start = -1;
        for (int i = 0; i < m; i++) {
            flag[i] = gas[i] - cost[i];
            if (start == -1 && flag[i] >=0) {
                start = i;
            }
            sum = sum + flag[i];
        }
        if (sum < 0) {
            return -1;
        }
        while (start < m) {
            while (flag[start] < 0 && start < m) {
                start++;
            }
            int step=start;
            int less=0;
            for (int i = 0; i < m; i++) {
                step=step%m;
                less=less+flag[step];
                if(less<0){
                    break;
                }
                step++;
            }
            if(less>=0){
                return start;
            }
            start++;
        }
        return -1;
    }

    //On
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int i = 0;
        while (i < n) {
            int sumOfGas = 0, sumOfCost = 0;
            int cnt = 0;
            while (cnt < n) {
                int j = (i + cnt) % n;
                sumOfGas += gas[j];
                sumOfCost += cost[j];
                if (sumOfCost > sumOfGas) {
                    break;
                }
                cnt++;
            }
            if (cnt == n) {
                return i;
            } else {
                i = i + cnt + 1;
            }
        }
        return -1;
    }

}
