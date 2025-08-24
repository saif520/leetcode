class Solution {
    public String longestNiceSubstring(String inputString) {
        // Length of the input string
        int stringLength = inputString.length();
      
        // 'start' will keep the index at which the longest nice substring begins
        int start = -1;
        // 'maxLength' is the length of the longest nice substring found so far
        int maxLength = 0;
      
        // Iterate over each character in the string as the starting point
        for (int i = 0; i < stringLength; ++i) {
            // 'lowerCaseBitmask' and 'upperCaseBitmask' are bitmasks to keep track of
            // lowercase and uppercase characters encountered
            int lowerCaseBitmask = 0, upperCaseBitmask = 0;
          
            // Try extending the substring from the starting point 'i' to 'j'
            for (int j = i; j < stringLength; ++j) {
                // Get the current character
                char currentChar = inputString.charAt(j);

                // If it's lowercase, set the corresponding bit in the bitmask
                if (Character.isLowerCase(currentChar)) {
                    lowerCaseBitmask |= 1 << (currentChar - 'a');
                }
                // If it's uppercase, set the corresponding bit in the bitmask
                else {
                    upperCaseBitmask |= 1 << (currentChar - 'A');
                }

                // Check if the substring from 'i' to 'j' is a nice string
                // A nice string has the same set of lowercase and uppercase characters
                if (lowerCaseBitmask == upperCaseBitmask && maxLength < j - i + 1) {
                    // Update the maxLength and the starting index 'start'
                    maxLength = j - i + 1;
                    start = i;
                }
            }
        }

        // If 'start' was updated (meaning a nice substring was found), return it
        // Otherwise, if no nice substring exists, return an empty string
        return (start == -1) ? "" : inputString.substring(start, start + maxLength);
    }
}