class Solution {
    public int projectionArea(int[][] grid) {
         int areaXY = 0; // Area projection onto the XY plane
        int areaYZ = 0; // Area projection onto the YZ plane
        int areaZX = 0; // Area projection onto the ZX plane
      
        // We assume grid is a square (n x n matrix), so we use grid.length to get 'n'.
        for (int i = 0, n = grid.length; i < n; ++i) {
            int maxYForYZ = 0; // Max height in y-direction for YZ projection
            int maxXForZX = 0; // Max height in x-direction for ZX projection
          
            // Iterate over each row and column to calculate heights
            for (int j = 0; j < n; ++j) {
              
                // Increment area counter for XY plane if height > 0
                if (grid[i][j] > 0) {
                    areaXY++;
                }
              
                // Determine the tallest point in the current row for YZ projection
                maxYForYZ = Math.max(maxYForYZ, grid[i][j]);
              
                // Determine the tallest point in the current column for ZX projection
                maxXForZX = Math.max(maxXForZX, grid[j][i]);
            }
          
            // Accumulate the maximum height of the grid for YZ and ZX projections
            areaYZ += maxYForYZ;
            areaZX += maxXForZX;
        }
      
        // The total projection area is the sum of all three individual areas
        return areaXY + areaYZ + areaZX;
    }
}