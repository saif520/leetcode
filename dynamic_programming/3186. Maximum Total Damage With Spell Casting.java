class Solution {
    // Memoization array to store computed results for each index
    private Long[] memo;
  
    // Input array of power values
    private int[] power;
  
    // Map to store frequency count of each power value
    private Map<Integer, Integer> frequencyMap;
  
    // Array to store the next valid index after skipping conflicting elements
    private int[] nextValidIndex;
  
    // Length of the power array
    private int n;

    public long maximumTotalDamage(int[] power) {
        // Sort the power array to group same values and enable binary search
        Arrays.sort(power);
      
        // Initialize instance variables
        this.power = power;
        this.n = power.length;
        this.memo = new Long[n];
        this.frequencyMap = new HashMap<>(n);
        this.nextValidIndex = new int[n];
      
        // Preprocess the array
        for (int i = 0; i < n; i++) {
            // Count frequency of each power value
            frequencyMap.merge(power[i], 1, Integer::sum);
          
            // Find the first index where power[index] >= power[i] + 3
            // This represents the next valid position after skipping conflicting elements
            int searchTarget = power[i] + 3;
            int nextIndex = Arrays.binarySearch(power, searchTarget);
          
            // If exact match not found, binarySearch returns -(insertion point) - 1
            // Convert to the actual insertion point (first valid index)
            nextIndex = nextIndex < 0 ? -nextIndex - 1 : nextIndex;
            nextValidIndex[i] = nextIndex;
        }
      
        // Start dynamic programming from index 0
        return dfs(0);
    }

    /**
     * Dynamic programming function to find maximum damage starting from index i
     * @param i current index in the power array
     * @return maximum total damage achievable from index i to end
     */
    private long dfs(int i) {
        // Base case: reached end of array
        if (i >= n) {
            return 0;
        }
      
        // Return memoized result if already computed
        if (memo[i] != null) {
            return memo[i];
        }
      
        // Option 1: Skip current power value group
        // Move to the next different power value
        long skipCurrent = dfs(i + frequencyMap.get(power[i]));
      
        // Option 2: Take current power value group
        // Calculate damage from all occurrences of current power value
        // Then continue from the next valid index (skipping conflicting values)
        long takeCurrent = (long) power[i] * frequencyMap.get(power[i]) + dfs(nextValidIndex[i]);
      
        // Store and return the maximum of both options
        memo[i] = Math.max(skipCurrent, takeCurrent);
        return memo[i];
    }
}
