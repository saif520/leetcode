class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int currentIndex = 0; // Pointer into str2 to track our current progress.
        int lengthOfStr2 = str2.length(); // Total length of str2.

        // Iterate through each character of str1.
        for (char currentChar : str1.toCharArray()) {
            // Calculate the next character in the alphabetical order ('z' wraps to 'a').
            char nextChar = currentChar == 'z' ? 'a' : (char) (currentChar + 1);

            // Check if the current character in str1 matches the current or next valid character in str2.
            if (currentIndex < lengthOfStr2 && 
                (str2.charAt(currentIndex) == currentChar || str2.charAt(currentIndex) == nextChar)) {
                currentIndex++; // Move to the next character in str2.
            }
        }

        // str2 is a subsequence of str1 only if we have traversed its entire length.
        return currentIndex == lengthOfStr2;
    }
}