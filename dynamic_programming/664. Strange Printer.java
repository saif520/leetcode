class Solution {
    public int strangePrinter(String s) {
        final int INFINITY = Integer.MAX_VALUE / 2; // value representing infinity, halved to avoid overflow when adding
        int length = s.length(); // length of the input string
        int[][] dp = new int[length][length]; // initialize DP table, dp[i][j] represents the minimal turns to print s[i..j]
      
        for (int[] row : dp) {
            Arrays.fill(row, INFINITY); // fill the DP table with 'infinity' as initial value
        }
      
        for (int i = length - 1; i >= 0; --i) { // iterate from the end to the beginning of the string
            dp[i][i] = 1; // it takes 1 turn to print a single character
          
            for (int j = i + 1; j < length; ++j) { // iterate over the rest of the string
                if (s.charAt(i) == s.charAt(j)) { // if characters match, it costs the same as without the last character
                    dp[i][j] = dp[i][j - 1];
                } else {
                    for (int k = i; k < j; ++k) { // split the range into two parts and sum their costs
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]); // find the minimum cost
                    }
                }
            }
        }
      
        return dp[0][length - 1]; // answer is the minimal turns to print the entire string s[0..length-1]
    }
}