class Solution {
    public long gridGame(int[][] newgrid) {
        int n = newgrid[0].length;
        long grid[][]=new long[2][n];
        for(int i=0;i<2;i++){
            for(int j=0;j<n;j++){
                grid[i][j]=newgrid[i][j];
            }
        }
		// suffix sum array on the 0th row
		for(int i = n-2;i>=0;i--){
			grid[0][i] += grid[0][i+1];
		}
		//prefix sum array on the 1th row
		for(int i = 1;i<n;i++){
			grid[1][i] += grid[1][i-1];
		}
		//start exploring all possible paths
		long overallAns = Long.MAX_VALUE;
		for(int i = 0;i<n;i++){
			//i -> if robot1 switches row on the ith col
			//options for robot 2
			long firstOption = i+1 == n ? 0 : grid[0][i+1];
			long secondOption = i-1 < 0 ? 0 : grid[1][i-1];
			long robot2sChoice = Math.max(firstOption,secondOption);
			overallAns = Math.min(overallAns,robot2sChoice);
		}
		return overallAns;
    }
}