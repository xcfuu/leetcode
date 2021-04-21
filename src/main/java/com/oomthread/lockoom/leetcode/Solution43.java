package com.oomthread.lockoom.leetcode;

//字符串相乘
public class Solution43 {
    public static String multiply(String num1, String num2) {
        if (num1 == null || "".equals(num1) || num2 == null || "".equals(num2)) {
            return "";
        }
        if ((num1.length() == 1 && "0".equals(num1)) || (num2.length() == 1 && "0".equals(num2))) {
            return "0";
        }

        if ((num2.length() >= 1 && num1.length() == 1 && "1".equals(num1))) {
            return num2;
        }

        if ((num1.length() >= 1 && num2.length() == 1 && "1".equals(num2))) {
            return num1;
        }

        char[] nums1;
        char[] nums2;
        if (num1.length() > num2.length()) {
            nums1 = num1.toCharArray();
            nums2 = num2.toCharArray();
        } else {
            nums1 = num2.toCharArray();
            nums2 = num1.toCharArray();
        }
        int[] narray1 = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            narray1[i] = nums1[nums1.length-1-i]-'0';
        }
        int[] narray2 = new int[nums2.length];
        for (int i = 0; i < nums2.length; i++) {
            narray2[i] =nums2[nums2.length-1-i]-'0';
        }

        int[] res = new int[narray1.length + narray2.length];
        for (int i = 0; i < narray2.length; i++) {
            int flag = 0;
            int start = i;
            for (int j = 0; j < narray1.length; j++) {
                int sum = narray2[i]*narray1[j]+res[start]+flag;
                res[start]=sum%10;
                flag=sum/10;
                start++;
            }
            while(flag>0){
                int sum = res[start]+flag;
                res[start]=sum%10;
                flag=sum/10;
                start++;
            }
        }

        StringBuilder stringBuilder= new StringBuilder();
        boolean flag=false;
        boolean start=true;
        for (int i = res.length-1; i>=0; i--) {
            if(start&&res[i]!=0){
                flag=true;
                start=false;
            }
            if(flag){
                stringBuilder.append(res[i]);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(Solution43.multiply(Integer.MAX_VALUE+"",Integer.MAX_VALUE+""));
        System.out.println(Integer.MAX_VALUE);
    }

}
