class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        // Initialize running sum, minimum and maximum values observed while simulating the array creation
        long runningSum = 0;
        long minObserved = 0;
        long maxObserved = 0;

        // Iterate over the array of differences
        for (int difference : differences) {
            // Update the running sum with the current difference
            runningSum += difference;

            // Update the minimum observed sum, if necessary
            minObserved = Math.min(minObserved, runningSum);

            // Update the maximum observed sum, if necessary
            maxObserved = Math.max(maxObserved, runningSum);
        }

        // Compute the number of possible starting values that satisfy the bounds
        int totalValidArrays = Math.max(0, (int) (upper - lower - (maxObserved - minObserved) + 1));

        // Return the computed total number of valid arrays
        return totalValidArrays;
    }
}