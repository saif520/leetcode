class Solution {
    public int minDistance(String word1, String word2) {
        int lenWord1 = word1.length();
        int lenWord2 = word2.length();

        // 'dp' table where 'dp[i][j]' will be the edit distance of first 'i' characters of 'word1' and first 'j' characters of 'word2'
        int[][] dp = new int[lenWord1 + 1][lenWord2 + 1];

        // Initialize the first column, which represents the edits required to convert 'word1' substrings into an empty 'word2'
        for (int i = 1; i <= lenWord1; ++i) {
            dp[i][0] = i;
        }

        // Initialize the first row, which represents the edits required to convert an empty 'word1' into substrings of 'word2'
        for (int j = 1; j <= lenWord2; ++j) {
            dp[0][j] = j;
        }

        // Fill in the rest of the DP table
        for (int i = 1; i <= lenWord1; ++i) {
            for (int j = 1; j <= lenWord2; ++j) {
                // If the current characters of 'word1' and 'word2' match, no additional edit is required, take the diagonal value
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // If the characters don't match, consider the minimum of the cell to the left or above plus one for the edit
                    dp[i][j] = 1 + Math.min(dp[i - 1][j],     // Deletion
                                            dp[i][j - 1]);    // Insertion
                }
            }
        }

        // The edit distance between 'word1' and 'word2' is in the bottom-right corner of the DP table
        return dp[lenWord1][lenWord2];
    }
}