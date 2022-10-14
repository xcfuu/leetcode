package com.oomthread.lockoom.leetcode.leetcode.editor.cn;


//leetcode submit region begin(Prohibit modification and deletion)
class NumArray {

//    private int[] numArray;
//    public NumArray(int[] nums) {
//        numArray=nums;
//    }
//
//    public int sumRange(int left, int right) {
//        int num=0;
//        for (int i = 0; i < numArray.length; i++) {
//            if(i>=left && i<=right){
//               num=num+numArray[i];
//            }
//        }
//        return num;
//    }

    int[] sums;

    public NumArray(int[] nums) {
        int n = nums.length;
        sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }



}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)
