package com.oomthread.lockoom.leetcode.leetcode.editor.cn;
//输入：s1 = "ab" s2 = "eidbaooo"
//        输出：true
//        解释：s2 包含 s1 的排列之一 ("ba").
//        示例 2：
//
//        输入：s1= "ab" s2 = "eidboaoo"
//        输出：false

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : s1.toCharArray()) {
            Integer val = need.get(c);
            need.put(c, val == null ? 1 : val + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                Integer val = window.get(c);
                window.put(c, val == null ? 1 : val + 1);
                if (window.get(c) == need.get(c))
                    valid++;
            }
            // 判断左侧窗口是否要收缩
            while (right - left >= s1.length()) {
                // 在这里判断是否找到了合法的子串
                if (valid == need.size())
                    return true;
                char d = s2.charAt(left);
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d) == need.get(d)){
                        valid--;
                    }
                    Integer val = window.get(d);
                    window.put(d, val - 1);
                }
            }
        }
        // 未找到符合条件的子串
        return false;




    }
}
//leetcode submit region end(Prohibit modification and deletion)
