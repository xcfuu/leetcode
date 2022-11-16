package com.oomthread.lockoom.leetcode.leetcode.editor.cn;


//leetcode submit region begin(Prohibit modification and deletion)
class NumMatrix {
    private int[][] numMatrix;

    public NumMatrix(int[][] matrix) {
        numMatrix=matrix;
        for (int i = 0; i < numMatrix.length; i++) {
            for (int i1 = 0; i1 < numMatrix[i].length; i1++) {
                if(i1>0){
                    numMatrix[i][i1]=numMatrix[i][i1]+ numMatrix[i][i1-1];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum=0;
        for (int i = row1; i <= row2; i++) {
            if(col1==0){
                sum=sum+numMatrix[i][col2];
            }else {
                sum=sum+numMatrix[i][col2]-numMatrix[i][col1-1];
            }

        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)
