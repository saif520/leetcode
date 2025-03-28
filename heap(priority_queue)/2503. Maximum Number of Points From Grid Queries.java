class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int queryLength = queries.length;
        // Array to store value and index of each query
        int[][] sortedQueries = new int[queryLength][2];
        // Fill the array with queries and their original indexes
        for (int i = 0; i < queryLength; ++i) {
            sortedQueries[i] = new int[] { queries[i], i };
        }
        // Sort queries based on their values
        Arrays.sort(sortedQueries, (a, b) -> a[0] - b[0]);
      
        // Initialize the answer array to store results for each query
        int[] answers = new int[queryLength];
        // Get the dimensions of the grid
        int rows = grid.length;
        int columns = grid[0].length;
        // Keep track of visited cells
        boolean[][] visited = new boolean[rows][columns];
        // Mark the start cell as visited
        visited[0][0] = true;
      
        // Priority queue to store cell values with coordinates, sorted by value
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // Offer the first cell to the priority queue
        queue.offer(new int[] { grid[0][0], 0, 0 });
      
        // Array to help navigate through neighbors of a cell
        int[] directions = new int[] { -1, 0, 1, 0, -1 };
        // Counter to keep the count of cells processed
        int count = 0;
      
        // Process each sorted query
        for (int[] query : sortedQueries) {
            int queryValue = query[0];
            int queryIndex = query[1];
          
            // Poll cells with value less than the current query value
            while (!queue.isEmpty() && queue.peek()[0] < queryValue) {
                int[] cell = queue.poll();
                // Increment the count whenever a cell is polled
                ++count;
              
                // Navigate to neighboring cells
                for (int i = 0; i < 4; ++i) {
                    int newRow = cell[1] + directions[i];
                    int newColumn = cell[2] + directions[i + 1];
                  
                    // If the neighbor is within bounds and not visited yet
                    if (newRow >= 0 && newRow < rows 
                        && newColumn >= 0 && newColumn < columns 
                        && !visited[newRow][newColumn]) {
                        // Mark as visited
                        visited[newRow][newColumn] = true;
                        // Add to queue with values
                        queue.offer(new int[] { grid[newRow][newColumn], newRow, newColumn });
                    }
                }
            }
            // Save counter value in the answer array corresponding to the original query index
            answers[queryIndex] = count;
        }
        // Return the answer array with counts for each query
        return answers;
    }
}