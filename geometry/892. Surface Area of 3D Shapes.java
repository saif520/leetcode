class Solution {
    public int surfaceArea(int[][] grid) {
        // Length of the grid (number of rows/columns in the grid)
        int n = grid.length;
        // Initialize surface area to 0
        int totalSurfaceArea = 0;

        // Iterate over each cell in the grid
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                // If the cell has at least one cube
                if (grid[i][j] > 0) {
                    // Top and bottom surface area (2) + 4 sides for each cube in the cell
                    totalSurfaceArea += 2 + grid[i][j] * 4;

                    // Subtract the area of the sides that are shared with the adjacent cube on the left
                    if (i > 0) {
                        totalSurfaceArea -= Math.min(grid[i][j], grid[i - 1][j]) * 2;
                    }

                    // Subtract the area of the sides that are shared with the adjacent cube behind
                    if (j > 0) {
                        totalSurfaceArea -= Math.min(grid[i][j], grid[i][j - 1]) * 2;
                    }
                }
            }
        }

        // Return the total surface area
        return totalSurfaceArea;
    }
}