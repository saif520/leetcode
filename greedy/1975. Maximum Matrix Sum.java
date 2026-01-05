class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int n=matrix.length;
        long totalSum=0;
        int minAbsVal=Integer.MAX_VALUE;
        int negativeCount=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                totalSum+=Math.abs(matrix[i][j]);
                if(matrix[i][j]<0){
                    negativeCount++;
                }
                minAbsVal=Math.min(minAbsVal,Math.abs(matrix[i][j]));
            }
        }

        if(negativeCount%2!=0){
            totalSum-=2*minAbsVal;
        }

        return totalSum;
    }
}