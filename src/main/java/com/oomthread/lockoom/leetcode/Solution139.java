package com.oomthread.lockoom.leetcode;

import java.util.List;

/**
 * @Author xuechaofu
 * @Date 2023-11-09 16:40
 **/
public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {

        char[] chars = s.toCharArray();

        boolean[] dp = new boolean[chars.length + 1];

        dp[0] = true;

        // dp[j] =dp[j] | ( dp[j-n] &  chars[i-n]~chars[i]== chars1)
        for (int i = 0; i < chars.length; i++) {
            int j = i + 1;
            for (String s1 : wordDict) {
                char[] chars1 = s1.toCharArray();
                int n = chars1.length;
                if (j >= n) {
                    boolean flag = true;
                    for (int i1 = 0; i1 < n; i1++) {
                        if (chars1[i1] != chars[j - n + i1]) {
                            flag = false;
                            break;
                        }
                    }
                    dp[j] = dp[j] | (dp[j - n] & flag);
                }
            }
        }

        return dp[chars.length + 1];
    }
}
