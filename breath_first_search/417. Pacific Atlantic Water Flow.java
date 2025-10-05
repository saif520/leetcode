class Solution {
    // Global variables to store the grid and its dimensions
    private int[][] heights;
    private int rows;
    private int cols;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // Initialize dimensions
        rows = heights.length;
        cols = heights[0].length;
        this.heights = heights;
      
        // Queues for BFS from Pacific and Atlantic oceans
        Deque<int[]> pacificQueue = new LinkedList<>();
        Deque<int[]> atlanticQueue = new LinkedList<>();
      
        // Sets to track visited cells (encoded as row * cols + col)
        Set<Integer> pacificVisited = new HashSet<>();
        Set<Integer> atlanticVisited = new HashSet<>();
      
        // Initialize starting points for both oceans
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // Pacific Ocean: cells on top edge or left edge
                if (row == 0 || col == 0) {
                    int encodedPosition = row * cols + col;
                    pacificVisited.add(encodedPosition);
                    pacificQueue.offer(new int[] {row, col});
                }
                // Atlantic Ocean: cells on bottom edge or right edge
                if (row == rows - 1 || col == cols - 1) {
                    int encodedPosition = row * cols + col;
                    atlanticVisited.add(encodedPosition);
                    atlanticQueue.offer(new int[] {row, col});
                }
            }
        }
      
        // Perform BFS from both oceans to find reachable cells
        bfs(pacificQueue, pacificVisited);
        bfs(atlanticQueue, atlanticVisited);
      
        // Find cells that can reach both oceans
        List<List<Integer>> result = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int encodedPosition = row * cols + col;
                // If cell is reachable from both oceans, add to result
                if (pacificVisited.contains(encodedPosition) && 
                    atlanticVisited.contains(encodedPosition)) {
                    result.add(Arrays.asList(row, col));
                }
            }
        }
      
        return result;
    }

    private void bfs(Deque<int[]> queue, Set<Integer> visited) {
        // Direction vectors for moving up, right, down, left
        int[] directions = {-1, 0, 1, 0, -1};
      
        while (!queue.isEmpty()) {
            // Process all cells at current level
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                int[] currentCell = queue.poll();
                int currentRow = currentCell[0];
                int currentCol = currentCell[1];
              
                // Explore all 4 directions
                for (int dir = 0; dir < 4; dir++) {
                    int nextRow = currentRow + directions[dir];
                    int nextCol = currentCol + directions[dir + 1];
                    int encodedNextPosition = nextRow * cols + nextCol;
                  
                    // Check if next cell is valid and water can flow from it to current cell
                    if (nextRow >= 0 && nextRow < rows && 
                        nextCol >= 0 && nextCol < cols && 
                        !visited.contains(encodedNextPosition) &&
                        heights[nextRow][nextCol] >= heights[currentRow][currentCol]) {
                      
                        // Mark as visited and add to queue for further exploration
                        visited.add(encodedNextPosition);
                        queue.offer(new int[] {nextRow, nextCol});
                    }
                }
            }
        }
    }
}