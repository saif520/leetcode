class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        // Split both sentences into arrays of words
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");

        // Ensure words1 is the longer array
        if (words1.length < words2.length) {
            String[] temp = words1;
            words1 = words2;
            words2 = temp;
        }

        // Initialize lengths and indices
        int length1 = words1.length; // Length of the longer array
        int length2 = words2.length; // Length of the shorter array
        int startMatchCount = 0; // Count how many words match from the beginning
        int endMatchCount = 0; // Count how many words match from the end

        // Count matching words from the start
        while (startMatchCount < length2 && words1[startMatchCount].equals(words2[startMatchCount])) {
            startMatchCount++;
        }

        // Count matching words from the end
        while (endMatchCount < length2 && words1[length1 - 1 - endMatchCount].equals(words2[length2 - 1 - endMatchCount])) {
            endMatchCount++;
        }

        // Check if the total matching words are at least the number of words in the shorter sentence
        return startMatchCount + endMatchCount >= length2;
    }
}