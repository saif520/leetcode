class Solution {
    public int maxMoves(int[][] grid) {
        // Define the possible directions of movement
        int[][] directions = {{-1, 1}, {0, 1}, {1, 1}};
        // Dimensions of the grid
        int rows = grid.length, columns = grid[0].length;
        // Queue to keep track of positions to process
        Deque<int[]> queue = new ArrayDeque<>();
        // Start by adding all positions in the first column to the queue
        for (int row = 0; row < rows; ++row) {
            queue.offer(new int[] {row, 0});
        }
        // Distance array to keep track of the maximum moves to reach each cell
        int[][] distance = new int[rows][columns];
        // Variable to hold the final answer - maximum number of moves
        int maxMoves = 0;
        // Process each position in the queue
        while (!queue.isEmpty()) {
            // Get the next position from the queue
            var current = queue.poll();
            int currentRow = current[0], currentCol = current[1];
            // Explore all possible directions from the current position
            for (var direction : directions) {
                int nextRow = currentRow + direction[0], nextCol = currentCol + direction[1];
                // Check if the next position is within bounds and has a larger value in the grid
                // and whether we can reach it in a greater number of moves
                if (nextRow >= 0 && nextRow < rows && nextCol >= 0 && nextCol < columns &&
                    grid[nextRow][nextCol] > grid[currentRow][currentCol] &&
                    distance[nextRow][nextCol] < distance[currentRow][currentCol] + 1) {
                    // Update the distance for the next position
                    distance[nextRow][nextCol] = distance[currentRow][currentCol] + 1;
                    // Update the maxMoves if this move is greater
                    maxMoves = Math.max(maxMoves, distance[nextRow][nextCol]);
                    // Add the next position to the queue for further processing
                    queue.offer(new int[] {nextRow, nextCol});
                }
            }
        }
        // Return the maximum number of moves
        return maxMoves;
    }
}