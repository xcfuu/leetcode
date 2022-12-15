package com.oomthread.lockoom.leetcode.leetcode.editor.cn;


//leetcode submit region begin(Prohibit modification and deletion)
class Solution704 {
    public static int search(int[] nums, int target) {
        int size = nums.length;
        if (size == 0) {
            return -1;
        }
        int left = 0;
        int right = size;
        int min = (left + right) / 2;
        while (left != right) {
            if (target < nums[min]) {
                right = min;
            } else if (target > nums[min]) {
                left = min + 1;
            } else {
                return min;
            }
            min = (left + right) / 2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums ={1,2,3};
        System.out.println(Solution704.search(nums,3));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
