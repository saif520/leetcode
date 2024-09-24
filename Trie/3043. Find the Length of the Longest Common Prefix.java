class Solution {

    // Method to find the longest common prefix length represented in two arrays
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        // Create a HashSet to store unique prefixes
        Set<Integer> prefixes = new HashSet<>();
      
        // Iterate through every number in the first array
        for (int num : arr1) {
            // Loop to add all prefixes of the current number to the set
            for (int prefix = num; prefix > 0; prefix /= 10) {
                prefixes.add(prefix);
            }
        }
      
        // Initialize the variable 'longestPrefixLength' to store the length of the longest common prefix
        int longestPrefixLength = 0;
      
        // Iterate through every number in the second array
        for (int num : arr2) {
            // Loop to check if any prefix of the current number exists in the set
            for (int prefix = num; prefix > 0; prefix /= 10) {
                // If a common prefix is found
                if (prefixes.contains(prefix)) {
                    // Update 'longestPrefixLength' with the length of the current prefix if it's the longest found so far
                    longestPrefixLength = Math.max(longestPrefixLength, String.valueOf(prefix).length());
                    // Break the loop since we only need the longest common prefix
                    break;
                }
            }
        }
      
        // Return the length of the longest common prefix
        return longestPrefixLength;
    }
}