class Solution {
    private int numRows;
    private int numCols;
    private int[][] grid; // Renamed "matrix" to "grid" for clarity
    private int[][] dp; // Renamed "f" to "dp" for denoting the "dynamic programming" cache

    public int longestIncreasingPath(int[][] matrix) {
        numRows = matrix.length;
        numCols = matrix[0].length;
        dp = new int[numRows][numCols];
        this.grid = matrix;
        int longestPath = 0;

        // Iterate over each cell in the matrix
        for (int i = 0; i < numRows; ++i) {
            for (int j = 0; j < numCols; ++j) {
                // Update the longest path found so far
                longestPath = Math.max(longestPath, dfs(i, j));
            }
        }
      
        return longestPath;
    }

    private int dfs(int row, int col) {
        // If the current cell already contains a computed length, return it
        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        // Direction vectors for the 4 adjacent cells (up, right, down, left)
        int[] directions = {-1, 0, 1, 0, -1};
      
        // Explore all adjacent cells
        for (int k = 0; k < 4; k++) {
            int nextRow = row + directions[k];
            int nextCol = col + directions[k + 1];

            // Check if the next cell is within bounds and has a larger value than the current cell
            if (nextRow >= 0 && nextRow < numRows && nextCol >= 0 && nextCol < numCols && grid[nextRow][nextCol] > grid[row][col]) {
                // Update the length of the longest increasing path from the current cell
                dp[row][col] = Math.max(dp[row][col], dfs(nextRow, nextCol));
            }
        }

        // Increment the stored length by 1 to include the current cell and return it
        return ++dp[row][col];
    }
}