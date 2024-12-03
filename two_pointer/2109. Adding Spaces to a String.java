class Solution {
    public String addSpaces(String s, int[] spaces) {
        // StringBuilder is used for efficient string manipulation
        StringBuilder result = new StringBuilder();

        // Use two pointers: 'i' for string 's', and 'j' for the spaces array
        for (int i = 0, j = 0; i < s.length(); ++i) {
            // Check if we have more spaces to add and if the current position matches the
            // next space position
            if (j < spaces.length && i == spaces[j]) {
                // If so, append a space to the result
                result.append(' ');
                // Move to the next position in the spaces array
                ++j;
            }
            // Append the current character from string 's'
            result.append(s.charAt(i));
        }

        // Return the modified string with spaces added
        return result.toString();
    }
}