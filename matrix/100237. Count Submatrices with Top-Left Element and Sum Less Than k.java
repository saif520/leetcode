class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=1;j<grid[i].length;j++){
                grid[i][j]+=grid[i][j-1];
            }
        }
        
        for(int i=1;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                grid[i][j]+=grid[i-1][j];
            }
        }
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]<=k){
                    count++;
                }
            }
        }
        return count;
    }
}