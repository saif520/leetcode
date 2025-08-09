class Solution {
    // Globally store the input bomb coordinates and radii
    private int[][] bombs;

    public int maximumDetonation(int[][] bombs) {
        this.bombs = bombs;
        int n = bombs.length;

        // Generate a graph where g[i][j] is true if bomb i can trigger bomb j
        boolean[][] graph = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                graph[i][j] = canTrigger(i, j);
            }
        }

        // The maximum number of bombs that can be detonated by triggering one bomb
        int maxDetonations = 0;

        // Iterate over all bombs to find the starting bomb for the chain reaction
        for (int startBomb = 0; startBomb < n; ++startBomb) {
            Deque<Integer> queue = new ArrayDeque<>();
            queue.offer(startBomb);
          
            // Track visited bombs to avoid infinite loops in the chain reaction
            boolean[] visited = new boolean[n];
            visited[startBomb] = true;
            int detonatedCount = 0;
        
            // BFS to simulate a chain reaction starting from the current bomb
            while (!queue.isEmpty()) {
                int currentBomb = queue.poll();
                ++detonatedCount;
              
                // Check all reachable bombs that have not yet been visited/detonated
                for (int nextBomb = 0; nextBomb < n; ++nextBomb) {
                    if (graph[currentBomb][nextBomb] && !visited[nextBomb]) {
                        visited[nextBomb] = true;
                        queue.offer(nextBomb);
                    }
                }
            }
        
            // Record the maximum number of detonations achieved
            maxDetonations = Math.max(maxDetonations, detonatedCount);
        }

        return maxDetonations;
    }

    // Helper function to determine if bomb i can trigger bomb j
    private boolean canTrigger(int i, int j) {
        // No bomb can trigger itself
        if (i == j) {
            return false;
        }

        // Calculate the squared distance between bomb i and bomb j
        long deltaX = bombs[i][0] - bombs[j][0];
        long deltaY = bombs[i][1] - bombs[j][1];
        long radiusSquared = (long) bombs[i][2] * bombs[i][2];

        // If the squared distance is less than or equal to the squared bomb radius,
        // then bomb i can trigger bomb j
        return radiusSquared >= deltaX * deltaX + deltaY * deltaY;
    }
}