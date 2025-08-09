class Solution {
    public String clearStars(String s) {
        // Create an array of Deques to hold indices of each alphabet character
        Deque<Integer>[] characterIndices = new Deque[26];
        // Initialize each Deque in the array
        Arrays.setAll(characterIndices, k -> new ArrayDeque<>());
        int length = s.length();
        // Array to mark characters that should be removed
        boolean[] remove = new boolean[length];
      
        // Iterate over the characters in the string
        for (int i = 0; i < length; ++i) {
            if (s.charAt(i) == '*') {
                // Mark this star character for removal
                remove[i] = true;
                // Find the most recent character that is not a star and mark it for removal
                for (int j = 0; j < 26; ++j) {
                    if (!characterIndices[j].isEmpty()) {
                        remove[characterIndices[j].pop()] = true;
                        break; // Only remove one most recent character
                    }
                }
            } else {
                // Push the index of this character onto the respective Deque
                characterIndices[s.charAt(i) - 'a'].push(i);
            }
        }
      
        // Construct the resulting string excluding the marked characters
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            if (!remove[i]) {
                result.append(s.charAt(i));
            }
        }
      
        return result.toString();
    }
}