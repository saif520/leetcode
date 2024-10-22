class Solution {
    // Finds the shortest completing word in words that covers all letters in licensePlate
    public String shortestCompletingWord(String licensePlate, String[] words) {
        // Count the frequency of letters in the license plate, ignoring case and non-letters
        int[] licensePlateCounter = countLetters(licensePlate.toLowerCase());
      
        // Initialize the answer variable to hold the shortest completing word
        String shortestCompletingWord = null;
      
        // Initialize the shortest length found so far to an upper bound
        int minLength = 16; // As per the problem, words are at most 15 letters long
      
        // Iterate through each word in the array
        for (String word : words) {
            // Skip the word if its length is not less than the shortest length found so far
            if (minLength <= word.length()) {
                continue;
            }
          
            // Count the frequency of letters in the current word
            int[] wordCounter = countLetters(word);
          
            // Check if the current word covers all letters in the license plate
            if (doesWordCoverLicensePlate(licensePlateCounter, wordCounter)) {
                // Update the shortest completing word and the minimum length found so far
                minLength = word.length();
                shortestCompletingWord = word;
            }
        }
      
        // Return the shortest completing word found
        return shortestCompletingWord;
    }

    // Counts the frequency of each letter in a given word
    private int[] countLetters(String word) {
        int[] letterCounter = new int[26];
        // Iterate through each character in the word
        for (char c : word.toCharArray()) {
            // Increment the counter for the letter if it's a letter
            if (Character.isLetter(c)) {
                letterCounter[c - 'a']++;
            }
        }
        return letterCounter;
    }

    // Checks if wordCounter covers all the letters in licensePlateCounter
    private boolean doesWordCoverLicensePlate(int[] licensePlateCounter, int[] wordCounter) {
        // Iterate over each letter count
        for (int i = 0; i < 26; ++i) {
            // If the current letter's count in licensePlateCounter exceeds that in wordCounter,
            // the word does not cover the license plate, return false
            if (licensePlateCounter[i] > wordCounter[i]) {
                return false;
            }
        }
        // If all letter counts are covered, return true
        return true;
    }
}
