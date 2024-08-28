class Solution {
  
    // Method to count sub-islands
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int rows = grid1.length;    // Number of rows in the grid
        int cols = grid1[0].length; // Number of columns in the grid
        int subIslandsCount = 0;    // Initialize count of sub-islands
      
        // Iterate over all cells in grid2
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                // If we find a land cell in grid2, we perform DFS to check if it's a sub-island
                if (grid2[i][j] == 1 && isSubIsland(i, j, rows, cols, grid1, grid2)) {
                    subIslandsCount++; // Increment count if a sub-island is found
                }
            }
        }
        return subIslandsCount; // Return the total count of sub-islands
    }

    // Helper method to perform DFS and check if the current island in grid2 is a sub-island of grid1
    private boolean isSubIsland(int row, int col, int rows, int cols, int[][] grid1, int[][] grid2) {
        // Check if the current cell is also a land cell in grid1; initialize as a potential sub-island
        boolean isSub = grid1[row][col] == 1;
        grid2[row][col] = 0; // Mark the cell as visited by setting it to water
      
        // Directions for top, right, bottom, and left (for traversing adjacent cells)
        int[] dirRow = {-1, 0, 1, 0};
        int[] dirCol = {0, 1, 0, -1};
      
        // Explore all adjacent cells
        for (int k = 0; k < 4; ++k) {
            int newRow = row + dirRow[k];
            int newCol = col + dirCol[k];
            // Check if the adjacent cell is within grid bounds and has not been visited
            if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid2[newRow][newCol] == 1
                // Recursively call DFS; if any part of the island is not a sub-island, mark as not a sub-island
                && !isSubIsland(newRow, newCol, rows, cols, grid1, grid2)) {
                isSub = false;
            }
        }
        return isSub; // Return true if all parts of the island are sub-islands, false otherwise
    }
}