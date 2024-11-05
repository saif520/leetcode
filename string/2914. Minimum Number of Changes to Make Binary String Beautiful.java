class Solution {
    public int minChanges(String s) {
        int changesNeeded = 0; // Initialize a counter for the number of changes needed
      
        // Iterate over the string starting from the second character, checking every other character
        for (int i = 1; i < s.length(); i += 2) {
            // If the current character is not the same as the previous character,
            // we need to change it to make it the same
            if (s.charAt(i) != s.charAt(i - 1)) {
                changesNeeded++; // Increment the counter for the number of changes needed
            }
        }
      
        // Return the total number of changes required to make the string's odd and even characters match
        return changesNeeded;
    }
}