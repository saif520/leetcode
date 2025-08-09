class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
         // Method to return the coordinates of all cells in the matrix, sorted by their distance from (rCenter, cCenter)
        // Initialize a queue to perform the breadth-first search
        Deque<int[]> queue = new ArrayDeque<>();
        // Start from the center cell
        queue.offer(new int[] {rCenter, cCenter});
      
        // Create a visited matrix to keep track of visited cells
        boolean[][] visited = new boolean[rows][cols];
        // Mark the center cell as visited
        visited[rCenter][cCenter] = true;
      
        // Create a result array to hold all cells in the required order
        int[][] result = new int[rows * cols][2];
        // Use the `dirs` array to explore in all four directions
        int[] dirs = {-1, 0, 1, 0, -1};
        // Index to insert the next point in `result`
        int index = 0;
      
        // Perform breadth-first search
        while (!queue.isEmpty()) {
            for (int size = queue.size(); size > 0; size--) {
                // Get the current cell from the queue
                int[] point = queue.poll();
                // Assign the current cell's coordinates to the result array
                result[index++] = point;
              
                // Explore the neighbors of the current cell
                for (int k = 0; k < 4; ++k) {
                    int x = point[0] + dirs[k], y = point[1] + dirs[k + 1];
                    // Check for valid boundary conditions and unvisited state
                    if (x >= 0 && x < rows && y >= 0 && y < cols && !visited[x][y]) {
                        // Mark the new cell as visited
                        visited[x][y] = true;
                        // Add new cell's coordinates to the queue
                        queue.offer(new int[] {x, y});
                    }
                }
            }
        }
        // Return the result array containing all cell coordinates
        return result;
    }
}