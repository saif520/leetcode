class Solution {
    public boolean closeStrings(String word1, String word2) {
        // Create frequency arrays for both strings (26 letters in alphabet)
        int[] frequencyArray1 = new int[26];
        int[] frequencyArray2 = new int[26];
      
        // Count character frequencies in word1
        for (int i = 0; i < word1.length(); i++) {
            frequencyArray1[word1.charAt(i) - 'a']++;
        }
      
        // Count character frequencies in word2
        for (int i = 0; i < word2.length(); i++) {
            frequencyArray2[word2.charAt(i) - 'a']++;
        }
      
        // Check if both strings have the same set of unique characters
        // If one string has a character that the other doesn't, they can't be close
        for (int i = 0; i < 26; i++) {
            if ((frequencyArray1[i] == 0) != (frequencyArray2[i] == 0)) {
                return false;
            }
        }
      
        // Sort both frequency arrays to compare frequency distributions
        Arrays.sort(frequencyArray1);
        Arrays.sort(frequencyArray2);
      
        // Check if the sorted frequency arrays are equal
        // This verifies that both strings have the same frequency distribution
        return Arrays.equals(frequencyArray1, frequencyArray2);
    }
}