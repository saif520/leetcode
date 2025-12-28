class Solution {
    public int countNegatives(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int l = 0, r = m - 1;
            int firstNeg = m; // default: no negatives

            while (l <= r) {
                int mid = (l + r) / 2;
                if (grid[i][mid] < 0) {
                    firstNeg = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            count += (m - firstNeg);
        }
        return count;
    }
}
