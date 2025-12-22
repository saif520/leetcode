class Solution {
    public int minDeletionSize(String[] strs) {
        int rows = strs.length;
        int cols = strs[0].length();

        int[] dp = new int[cols];
        Arrays.fill(dp, 1);

        // Iterate columns from right to left
        for (int c1 = cols - 2; c1 >= 0; c1--) {
            for (int c2 = c1 + 1; c2 < cols; c2++) {
                boolean valid = true;

                // Check all rows
                for (int r = 0; r < rows; r++) {
                    if (strs[r].charAt(c1) > strs[r].charAt(c2)) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    dp[c1] = Math.max(dp[c1], 1 + dp[c2]);
                }
            }
        }

        int maxLIS = 0;
        for (int val : dp) {
            maxLIS = Math.max(maxLIS, val);
        }

        return cols - maxLIS;
    }
}
