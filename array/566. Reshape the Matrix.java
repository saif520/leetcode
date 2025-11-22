class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int res[][]=new int[r][c];
        int row=mat.length;
        int col=mat[0].length;

        int s=row*col;
        if(s==1){
            s=2;
        }
        if(s==2){
            return mat;
        }
        if(r*c>s){
            return mat;
        }
        if(r*c<s){
            return mat;
        }

        int arr[]=new int[s];
        int a=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                arr[a++]=mat[i][j];
            }
        }

        int k=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                res[i][j]=arr[k];
                k++;
            }
        }

        return res;

    }
}