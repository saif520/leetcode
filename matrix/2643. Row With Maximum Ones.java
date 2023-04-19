class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int row=mat.length;
        int col=mat[0].length;
        int max=0;
        int index=0;
        for(int i=0;i<row;i++){
            int count=0;
            for(int j=0;j<col;j++){
                if(mat[i][j]==1){
                    count++;
                }
            }
            if(count>max){
                max=count;
                index=i;
            }
        }
        int ans[]=new int[2];
        ans[0]=index;
        ans[1]=max;
        return ans;
    }
}