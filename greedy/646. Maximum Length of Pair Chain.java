class Solution {
    public int findLongestChain(int[][] pairs) {
                // Sort the pairs array by the second element of each pair (i.e., end time of the interval)
        Arrays.sort(pairs, Comparator.comparingInt(pair -> pair[1]));

        // Initialize the count of the longest chain as 0
        int longestChainLength = 0;

        // Initialize 'currentEnd' to the minimum integer value
        int currentEnd = Integer.MIN_VALUE;

        // Iterate through the sorted pairs
        for (int[] pair : pairs) {
            // If the current pair's start time is greater than 'currentEnd'
            if (currentEnd < pair[0]) {
                // Update 'currentEnd' to the end time of the current pair
                currentEnd = pair[1];

                // Increment the count of the chain as we've found a non-overlapping pair
                ++longestChainLength;
            }
        }

        // Return the length of the longest chain found
        return longestChainLength;
    }
}