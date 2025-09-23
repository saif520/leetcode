class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Convert word list to HashSet for O(1) lookup
        Set<String> wordSet = new HashSet<>(wordDict);
      
        // Get the length of the input string
        int length = s.length();
      
        // dp[i] represents whether substring s[0...i-1] can be segmented into dictionary words
        // dp[0] is true (empty string can always be segmented)
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
      
        // Iterate through each position in the string
        for (int endIndex = 1; endIndex <= length; endIndex++) {
            // Check all possible starting positions for the current ending position
            for (int startIndex = 0; startIndex < endIndex; startIndex++) {
                // If substring s[0...startIndex-1] can be segmented (dp[startIndex] is true)
                // AND substring s[startIndex...endIndex-1] exists in the dictionary
                // Then substring s[0...endIndex-1] can also be segmented
                if (dp[startIndex] && wordSet.contains(s.substring(startIndex, endIndex))) {
                    dp[endIndex] = true;
                    break; // No need to check other starting positions
                }
            }
        }
      
        // Return whether the entire string can be segmented
        return dp[length];
    }
}