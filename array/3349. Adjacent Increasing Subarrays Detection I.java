class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        // Track the maximum valid length found
        int maxValidLength = 0;
        // Length of the previous strictly increasing subarray
        int previousLength = 0;
        // Length of the current strictly increasing subarray being processed
        int currentLength = 0;
      
        int n = nums.size();
      
        // Iterate through all elements in the list
        for (int i = 0; i < n; i++) {
            // Increment current subarray length
            currentLength++;
          
            // Check if we've reached the end of a strictly increasing subarray
            // This happens when we're at the last element OR the next element is not greater
            if (i == n - 1 || nums.get(i) >= nums.get(i + 1)) {
                // Update maximum valid length considering two cases:
                // 1. Using half of the current subarray (split into two equal parts)
                // 2. Using adjacent subarrays (minimum of previous and current lengths)
                maxValidLength = Math.max(maxValidLength, 
                                         Math.max(currentLength / 2, 
                                                 Math.min(previousLength, currentLength)));
              
                // Current subarray becomes the previous for next iteration
                previousLength = currentLength;
                // Reset current length for the next subarray
                currentLength = 0;
            }
        }
      
        // Check if we found any valid configuration with length at least k
        return maxValidLength >= k;
    }
}
