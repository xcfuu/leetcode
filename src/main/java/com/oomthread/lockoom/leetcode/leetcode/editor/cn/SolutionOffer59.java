package com.oomthread.lockoom.leetcode.leetcode.editor.cn;


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class SolutionOffer59 {
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int size =nums.length;
//        int left=0;
//        int right=0;
//        int[] res=new int[size-k+1];
//        Map window=new TreeMap<Integer,Integer>();
//
//
//        for (int i = 0; i < k; i++) {
//            window.put(nums[i],"");
//            right++;
//        }
//
//        while(right<size){
//
//        }
//        return res;
//    }

    public int[] maxSlidingWindow(int[] nums, int k) {
            // 窗口个数
            int[] res = new int[nums.length - k + 1];
            LinkedList<Integer> queue = new LinkedList<>();

            // 遍历数组中元素，right表示滑动窗口右边界
            for(int right = 0; right < nums.length; right++) {
                // 如果队列不为空且当前考察元素大于等于队尾元素，则将队尾元素移除。
                // 直到，队列为空或当前考察元素小于新的队尾元素
                while (!queue.isEmpty() && nums[right] >= nums[queue.peekLast()]) {
                    queue.removeLast();
                }

                // 存储元素下标
                queue.addLast(right);

                // 计算窗口左侧边界
                int left = right - k +1;
                // 当队首元素的下标小于滑动窗口左侧边界left时
                // 表示队首元素已经不再滑动窗口内，因此将其从队首移除
                if (queue.peekFirst() < left) {
                    queue.removeFirst();
                }

                // 由于数组下标从0开始，因此当窗口右边界right+1大于等于窗口大小k时
                // 意味着窗口形成。此时，队首元素就是该窗口内的最大值
                if (right +1 >= k) {
                    res[left] = nums[queue.peekFirst()];
                }
            }
            return res;
    }

    /**
     * 计算月供金额
     * @param r     利率
     * @param nper  期数
     * @param pv    融资金额
     * @param fv
     * @param type
     * @return
     */
    private static Double pmt(double r, int nper, double pv, double fv, int type){
        if (r == 0 && nper > 0) {
            return (-pv - fv) / nper;
        }
        double pmt = -r * (pv * Math.pow(1 + r, nper) + fv) / ((1 + r * type) * (Math.pow(1 + r, nper) - 1));
        return pmt;
    }

    public static void main(String[] args) {
        System.out.println(SolutionOffer59.pmt(7.49d/1200,24,-300000d,150000,0));
    }

}
//leetcode submit region end(Prohibit modification and deletion)
