class Trie {
    private Trie[] children = new Trie[26]; // Each trie node can have up to 26 children for each letter of the alphabet
    private int count; // This variable counts the number of times a node is visited during insertions

    // Function to insert a word into the Trie
    public void insert(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a'; // Obtain the index by subtracting the ASCII value of 'a' from the character
            if (node.children[index] == null) {
                node.children[index] = new Trie(); // Create a new Trie node if it does not exist
            }
            node = node.children[index];
            node.count++; // Increment the count for each node visited
        }
    }

    // Function to compute the sum of the prefix scores for the given word
    public int search(String word) {
        Trie node = this;
        int sum = 0;
        for (char c : word.toCharArray()) {
            int index = c - 'a'; // Obtain the index as done in insert function
            if (node.children[index] == null) {
                return sum; // Return the current sum if the node is null (prefix does not exist)
            }
            node = node.children[index];
            sum += node.count; // Add the count of the visited node to the sum
        }
        return sum;
    }
}

class Solution {
    // Function to compute the sum of prefix scores for each word in the array
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie(); // Initialize a new Trie
        for (String word : words) {
            trie.insert(word); // Insert each word from the array into the Trie
        }
        int[] answer = new int[words.length]; // Create an array to hold the result
        for (int i = 0; i < words.length; i++) {
            answer[i] = trie.search(words[i]); // Compute the sum of prefix scores for each word in the array
        }
        return answer; // Return the computed scores
    }
}