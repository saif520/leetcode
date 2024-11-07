class Solution {
    public int largestCombination(int[] candidates) {
        int maxCombinationSize = 0; // This will hold the maximum combination size

        // Iterate through each bit position from 0 to 31 (for 32-bit integers)
        for (int i = 0; i < 32; ++i) {
            int count = 0; // Count of candidates that have the current bit set

            // Iterate through each candidate number
            for (int candidate : candidates) {
                // Right shift the candidate by i bits and check if the least significant bit is set
                // If it's set, increment the count for this bit position
                count += (candidate >> i) & 1;
            }

            // Compare the count for the current bit position with the maximum combination size
            // and update the maxCombinationSize if necessary
            maxCombinationSize = Math.max(maxCombinationSize, count);
        }

        // Return the maximum combination size found
        return maxCombinationSize;
    }
}