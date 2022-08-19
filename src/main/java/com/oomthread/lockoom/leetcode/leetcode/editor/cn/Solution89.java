package com.oomthread.lockoom.leetcode.leetcode.editor.cn;//n 位格雷码序列 是一个由 2ⁿ 个整数组成的序列，其中：
// 
// 每个整数都在范围 [0, 2ⁿ - 1] 内（含 0 和 2ⁿ - 1） 
// 第一个整数是 0 
// 一个整数在序列中出现 不超过一次 
// 每对 相邻 整数的二进制表示 恰好一位不同 ，且 
// 第一个 和 最后一个 整数的二进制表示 恰好一位不同 
// 
//
// 给你一个整数 n ，返回任一有效的 n 位格雷码序列 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2
//输出：[0,1,3,2]
//解释：
//[0,1,3,2] 的二进制表示是 [00,01,11,10] 。
//- 00 和 01 有一位不同
//- 01 和 11 有一位不同
//- 11 和 10 有一位不同
//- 10 和 00 有一位不同
//[0,2,3,1] 也是一个有效的格雷码序列，其二进制表示是 [00,10,11,01] 。
//- 00 和 10 有一位不同
//- 10 和 11 有一位不同
//- 11 和 01 有一位不同
//- 01 和 00 有一位不同
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 16 
// 
// Related Topics 位运算 数学 回溯 👍 530 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution89 {
//    public List<Integer> grayCode(int n) {
//        List<Integer> result= new ArrayList<>();
//        int[] twoByte=new int[n];
//        int[] flagArray=new int[n];
//        int size=n;
//        int first=0;
//
//
//
//    }
//
//    /**
//     *
//     * @param twoByte 上一次二进制数字
//     * @param flagArray 因使用过数字
//     * @param n 剩余未排列数字
//     * @param first 第一个数字
//     * @param result n 位格雷码序列
//     * @return
//     */
//    private Integer getInt(int[] twoByte,int[] flagArray,int n,int first,List<Integer> result){
//
//        for (int i = 0; i < n; i++) {
//
//
//        }
//
//    }


    List<Integer> grayCodeList = new ArrayList<>();
    StringBuilder binaryCode = new StringBuilder();
    int[] left = new int[]{0, 1};
    int[] right = new int[]{1, 0};

    public List<Integer> grayCode(int n) {
        // int[] nums ： 该数组表示接下来去取的二进制数字
        backTracing(n, binaryCode, left);
        return grayCodeList;
    }

    private void backTracing(int n, StringBuilder binaryCode, int[] nums) {
        // 找到一个符合的结果并添加到结果集中
        if (binaryCode.length() == n) {
            // 二进制与十进制转换 Integer.valueOf(binaryCode.toString(), 2);
            int grayCode = Integer.parseInt(binaryCode.toString(), 2);
            grayCodeList.add(grayCode);
            return;
        }

        // 回溯{0，1}数组
        binaryCode.append(nums[0]);
        backTracing(n, binaryCode, left);
        binaryCode.deleteCharAt(binaryCode.length() - 1);

        // 回溯{1，0}数组
        binaryCode.append(nums[1]);
        backTracing(n, binaryCode, right);
        binaryCode.deleteCharAt(binaryCode.length() - 1);
    }


}
//leetcode submit region end(Prohibit modification and deletion)
