class Solution {

    // Function to find the longest word in the dictionary that can be formed by deleting
    // some characters of the given string s.
    public String findLongestWord(String s, List<String> dictionary) {
        String longestWord = "";
        for (String word : dictionary) {
            // Check if current word can be formed by deleting some characters from s
            if (isSubsequence(s, word)) {
                // Update longestWord if current word is longer, or the same length but lexicographically smaller
                if (longestWord.length() < word.length() || 
                    (longestWord.length() == word.length() && word.compareTo(longestWord) < 0)) {
                    longestWord = word;
                }
            }
        }
        return longestWord;
    }

    // Helper method to check if string a is a subsequence of string b
    private boolean isSubsequence(String a, String b) {
        int i = 0; // Pointer for string a
        int j = 0; // Pointer for string b
        int m = a.length();
        int n = b.length();

        while (i < m && j < n) {
            if (a.charAt(i) == b.charAt(j)) {
                // If current characters match, move pointer j to next position in string b
                ++j;
            }
            // Always move pointer i to next position in string a
            ++i;
        }
      
        // If we have traversed the entire string b, it means it is a subsequence of a
        return j == n;
    }
}