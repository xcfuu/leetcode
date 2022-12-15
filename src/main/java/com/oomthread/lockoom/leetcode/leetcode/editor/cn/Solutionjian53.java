package com.oomthread.lockoom.leetcode.leetcode.editor.cn;


//leetcode submit region begin(Prohibit modification and deletion)
class Solutionjian53 {
    public static int search(int[] nums, int target) {
        int size = nums.length;
        if (size == 0) {
            return 0;
        }
        int left = 0;
        int right = size;
        int min = (left + right) / 2;

        int sum = 0;
        while (left != right) {
            if (nums[min] == target) {
                sum++;
                int left1 = min;
                int right1 = min;
                while (left1 > 0) {
                    left1--;
                    if (nums[left1] == target) {
                        sum++;
                    } else {
                        break;
                    }
                }
                while (right1 < size-1) {
                    right1++;
                    if (nums[right1] == target) {
                        sum++;
                    } else {
                        break;
                    }
                }
                break;
            } else if (nums[min] > target) {
                right = min;
            } else if (nums[min] < target) {
                left = min + 1;
            }
            min = (left + right) / 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {5};
        System.out.println(Solutionjian53.search(nums, 6));
    }

}
//leetcode submit region end(Prohibit modification and deletion)
