class Solution {
    public long minimumSteps(String s) {
        // Initialize the answer to 0
        long answer = 0;
        // Counter for the number of '1's found
        int oneCount = 0;
        // Length of the string
        int length = s.length();

        // Iterate over the string from right to left
        for (int i = length - 1; i >= 0; --i) {
            // Check if the current character is '1'
            if (s.charAt(i) == '1') {
                // Increase the count of '1's
                ++oneCount;
                // Add the number of steps to move this '1' to the right end
                answer += length - i - oneCount;
            }
        }
        // Return the total number of steps calculated
        return answer;
    }
}