class Pair {
    int first;
    int second; 
    public Pair(int first, int second) {
        this.first = first; 
        this.second = second; 
    }
}

class Solution {
    private void bfs(int ro, int co, int[][] vis, char[][] grid) {
        vis[ro][co] = 1; 
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(ro, co)); 
        int n = grid.length; 
        int m = grid[0].length; 
        
        // Directions array for the four cardinal directions
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        
        // Until the queue becomes empty
        while (!q.isEmpty()) {
            int row = q.peek().first; 
            int col = q.peek().second; 
            q.remove(); 
            
            // Traverse in the four cardinal directions and mark them if it's a land 
            for (int i = 0; i < 4; i++) {
                int nrow = row + dRow[i]; 
                int ncol = col + dCol[i]; 
                
                // Check if neighbor row and column are valid and is an unvisited land
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m 
                    && grid[nrow][ncol] == '1' && vis[nrow][ncol] == 0) {
                    vis[nrow][ncol] = 1; 
                    q.add(new Pair(nrow, ncol)); 
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length; 
        int m = grid[0].length; 
        int[][] vis = new int[n][m];
        int cnt = 0; 
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                // If not visited and is a land
                if (vis[row][col] == 0 && grid[row][col] == '1') {
                    cnt++; 
                    bfs(row, col, vis, grid); 
                }
            }
        }
        return cnt;
    }
}
