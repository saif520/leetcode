class Solution {
    public long maximumTripletValue(int[] nums) {
        // Initialize three variables to store the current maximum value,
        // the maximum difference found so far, and the answer we will return.
        long currentMax = 0;
        long maximumDiff = 0;
        long answer = 0;

        // Iterate through each number in the array.
        for (int num : nums) {
            // Calculate the tentative answer as the current number times the maximum difference,
            // update the answer if the result is greater than the current answer.
            answer = Math.max(answer, num * maximumDiff);

            // Update currentMax if the current number is greater than currentMax.
            currentMax = Math.max(currentMax, num);

            // Update maximumDiff if the difference between currentMax and current number
            // is greater than maximumDiff.
            maximumDiff = Math.max(maximumDiff, currentMax - num);
        }

        // Return the final answer.
        return answer;
    }
}