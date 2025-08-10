class Solution {
  
    // The function 'countBadPairs' returns the number of 'bad pairs' in the array.
    // A 'bad pair' (j, k) is defined as one where j < k and nums[j] - nums[k] != j - k.
    public long countBadPairs(int[] nums) {
        // This map is used to track the occurrence frequency of calculated values.
        Map<Integer, Integer> countMap = new HashMap<>();
        // Initialize 'badPairsCount' which will store the final count of bad pairs.
        long badPairsCount = 0;
      
        // Iterate through the array 'nums'.
        for (int i = 0; i < nums.length; ++i) {
            // Calculate 'difference' as the difference between the current index and the current element.
            int difference = i - nums[i];
          
            // Increment 'badPairsCount' by the number of indices processed minus the number of occurrences of 'difference.'
            // If 'difference' has not been seen, 'getOrDefault' will return 0, meaning no good pairs have been skipped.
            badPairsCount += i - countMap.getOrDefault(difference, 0);

            // Update the count of 'difference' in the map for future reference.
            // The 'merge' method is used to add 1 to the current count of 'difference' or to set it to 1 if not present.
            countMap.merge(difference, 1, Integer::sum);
        }
      
        return badPairsCount; // Return the total count of bad pairs.
    }
}