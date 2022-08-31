package com.oomthread.lockoom.leetcode.leetcode.editor.cn;//给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
//
// 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。 
//
// 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。 
//
// 注意：不允许旋转信封。 
// 
//
// 示例 1： 
//
// 
//输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出：3
//解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。 
//
// 示例 2： 
//
// 
//输入：envelopes = [[1,1],[1,1],[1,1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= envelopes.length <= 10⁵ 
// envelopes[i].length == 2 
// 1 <= wi, hi <= 10⁵ 
// 
// Related Topics 数组 二分查找 动态规划 排序 👍 793 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution354 {
    public static int maxEnvelopes(int[][] envelopes) {
        int[] dp = new int[envelopes.length];
        int[][] max = new int[1][2];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        for (int i = 0; i < envelopes.length; i++) {
            for (int j = i + 1; j < envelopes.length; j++) {
                if (envelopes[i][0] > envelopes[j][0]) {
                    int a = envelopes[i][0];
                    int b = envelopes[i][1];
                    envelopes[i][0] = envelopes[j][0];
                    envelopes[i][1] = envelopes[j][1];
                    envelopes[j][0] = a;
                    envelopes[j][1] = b;
                } else if (envelopes[i][0] == envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    int a = envelopes[i][0];
                    int b = envelopes[i][1];
                    envelopes[i][0] = envelopes[j][0];
                    envelopes[i][1] = envelopes[j][1];
                    envelopes[j][0] = a;
                    envelopes[j][1] = b;

                }
            }
        }


        int ans = 1;
        for (int i = 1; i < dp.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;

    }

    public static void main(String[] args) {
        //[[5,4],[6,4],[6,7],[2,3]]
        int[][] test = {{1, 3}, {3, 5}, {6, 7}, {6, 8}, {8, 4}, {9, 5}};
        //int[][] test = {{5,4}, {6,4}, {6,7}, {2,3}};
        System.out.println(Solution354.maxEnvelopes(test));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
