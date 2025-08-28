class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
      
        // Sort the diagonals starting from the last column and moving upwards
        for (int startRow = n - 2; startRow >= 0; --startRow) {
            int i = startRow, j = 0;
            List<Integer> diagonalElements = new ArrayList<>();
          
            // Collect elements of the current diagonal
            while (i < n && j < n) {
                diagonalElements.add(grid[i][j]);
                i++;
                j++;
            }
          
            // Sort the collected diagonal elements
            Collections.sort(diagonalElements);
          
            // Place the sorted elements back into the grid
            for (int element : diagonalElements) {
                grid[--i][--j] = element;
            }
        }
      
        // Sort the diagonals starting from the last row and moving to the first row
        for (int startColumn = n - 2; startColumn > 0; --startColumn) {
            int i = startColumn, j = n - 1;
            List<Integer> diagonalElements = new ArrayList<>();
          
            // Collect elements of the current diagonal
            while (i >= 0 && j >= 0) {
                diagonalElements.add(grid[i][j]);
                i--;
                j--;
            }
          
            // Sort the collected diagonal elements
            Collections.sort(diagonalElements);
          
            // Place the sorted elements back into the grid
            for (int element : diagonalElements) {
                grid[++i][++j] = element;
            }
        }
      
        // Return the sorted grid
        return grid;
    }
}