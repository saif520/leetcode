class Solution {
    final int[] deltaRow = {-1, 0, 1, 0};
    final int[] deltaCol = {0, 1, 0, -1};
    private boolean isValidEffort(int[][] heights, int mid){
        int rows = heights.length;
        int columns = heights[0].length; // dimensions for heights
        boolean[][] vis = new boolean[rows][columns]; // keeps track of whether or not we visited a node
        Queue<Integer> qRow = new LinkedList();
        Queue<Integer> qCol = new LinkedList();
        qRow.add(0);
        qCol.add(0); // BFS starts in top-left cell
        vis[0][0] = true;
        while (!qRow.isEmpty()) {
            int curRow = qRow.poll();
            int curCol = qCol.poll();
            for (int dir = 0; dir < 4; dir++) {
                int newRow = curRow + deltaRow[dir];
                int newCol = curCol + deltaCol[dir];
                if (newRow < 0 || newRow >= rows || newCol < 0
                    || newCol >= columns) { // check if cell is in boundary
                    continue;
                }
                if (vis[newRow][newCol]) { // check if cell has been visited
                    continue;
                }
                if (Math.abs(heights[newRow][newCol] - heights[curRow][curCol]) > mid){
                    // check if distance exceeds limit
                    continue;
                }
                vis[newRow][newCol] = true;
                qRow.add(newRow);
                qCol.add(newCol);
                // process next node
            }
        }
        return vis[rows-1][columns-1];
    }
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int columns = heights[0].length; // dimensions for heights
        int low = -1; // every effort less or equal to low will never be good
        int high = (int) 1e6; // every effort greater or equal to high will always be good
        int mid = (low + high) / 2;
        while (low + 1 < high) {
            if (isValidEffort(heights,mid)) {
                high = mid;
            } else {
                low = mid;
            }
            mid = (low + high) / 2;
        }
        return high;
    }
}