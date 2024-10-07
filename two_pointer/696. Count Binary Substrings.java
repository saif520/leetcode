class Solution {
    public int countBinarySubstrings(String s) {
        // Initialize the current index 'currentIndex' which is used to traverse the string
        int currentIndex = 0;
        // The length of the input string 's'
        int length = s.length();
        // A list to store the consecutive character counts
        List<Integer> groups = new ArrayList<>();
      
        // Traverse the entire string
        while (currentIndex < length) {
            // Starting count is 1 since we're looking at one character initially
            int count = 1;
            // Check if the next character is the same as the current one
            while (currentIndex + 1 < length && s.charAt(currentIndex + 1) == s.charAt(currentIndex)) {
                currentIndex++;
                count++;
            }
            // Add the count to the list of group counts
            groups.add(count);
            // Move to the next character
            currentIndex++;
        }
      
        // Initialize 'totalSubstrings' to count the number of valid binary substrings
        int totalSubstrings = 0;
        // Iterate through the list of group counts
        for (int i = 1; i < groups.size(); i++) {
            // Add the minimum count of adjacent groups since that is the maximum number of
            // valid substrings we can get from those two groups
            totalSubstrings += Math.min(groups.get(i - 1), groups.get(i));
        }
      
        // Return the total number of valid binary substrings
        return totalSubstrings;
    }
}