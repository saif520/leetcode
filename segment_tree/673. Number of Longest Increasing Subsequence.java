class Solution {
    public int findNumberOfLIS(int[] nums) {
        int maxLength = 0; // Store the length of the longest increasing subsequence
        int numberOfMaxLIS = 0; // Store the count of longest increasing subsequences
        int n = nums.length; // The length of the input array

        // Arrays to store the length of the longest subsequence up to each element
        int[] lengths = new int[n]; // dp[i] will be the length for nums[i]
        int[] counts = new int[n]; // cnt[i] will be the number of LIS for nums[i]

        for (int i = 0; i < n; i++) {
            lengths[i] = 1; // By default, the longest subsequence at each element is 1 (the element itself)
            counts[i] = 1; // By default, the count of subsequences at each element is 1

            // Check all elements before the i-th element
            for (int j = 0; j < i; j++) {
                // If the current element can extend the increasing subsequence
                if (nums[i] > nums[j]) {
                    // If a longer subsequence is found
                    if (lengths[j] + 1 > lengths[i]) {
                        lengths[i] = lengths[j] + 1; // Update the length for nums[i]
                        counts[i] = counts[j]; // Update the count for nums[i]
                    } else if (lengths[j] + 1 == lengths[i]) {
                        counts[i] += counts[j]; // If same length, add the count of subsequences from nums[j]
                    }
                }
            }
          
            // If a new maximum length of subsequence is found
            if (lengths[i] > maxLength) {
                maxLength = lengths[i]; // Update the maxLength with the new maximum
                numberOfMaxLIS = counts[i]; // Reset the count of LIS
            } else if (lengths[i] == maxLength) {
                // If same length subsequences are found, add the count to the total
                numberOfMaxLIS += counts[i];
            }
        }
      
        // Return the total count of longest increasing subsequences
        return numberOfMaxLIS;
    }
}