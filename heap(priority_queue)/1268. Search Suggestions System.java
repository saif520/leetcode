/**
 * Trie data structure for efficient prefix-based search
 * Each node stores up to 3 product indices for suggestions
 */
class Trie {
    // Array of child nodes for each lowercase letter (a-z)
    Trie[] children = new Trie[26];
    // List to store indices of products (max 3) that have this prefix
    List<Integer> productIndices = new ArrayList<>();

    /**
     * Inserts a word into the trie with its corresponding product index
     * @param word The product name to insert
     * @param index The index of the product in the sorted products array
     */
    public void insert(String word, int index) {
        Trie currentNode = this;
      
        // Traverse through each character in the word
        for (int i = 0; i < word.length(); i++) {
            // Calculate the index for the character (0-25 for a-z)
            int charIndex = word.charAt(i) - 'a';
          
            // Create a new node if it doesn't exist
            if (currentNode.children[charIndex] == null) {
                currentNode.children[charIndex] = new Trie();
            }
          
            // Move to the child node
            currentNode = currentNode.children[charIndex];
          
            // Store the product index (maximum 3 products per node)
            if (currentNode.productIndices.size() < 3) {
                currentNode.productIndices.add(index);
            }
        }
    }

    /**
     * Searches for product suggestions for each prefix of the search word
     * @param searchWord The word to search for
     * @return Array of lists containing product indices for each prefix
     */
    public List<Integer>[] search(String searchWord) {
        Trie currentNode = this;
        int wordLength = searchWord.length();
      
        // Initialize result array with empty lists for each character position
        List<Integer>[] results = new List[wordLength];
        Arrays.setAll(results, i -> new ArrayList<>());
      
        // Traverse through each character of the search word
        for (int i = 0; i < wordLength; i++) {
            int charIndex = searchWord.charAt(i) - 'a';
          
            // If no matching child exists, stop searching
            if (currentNode.children[charIndex] == null) {
                break;
            }
          
            // Move to the child node and store its product indices
            currentNode = currentNode.children[charIndex];
            results[i] = currentNode.productIndices;
        }
      
        return results;
    }
}

/**
 * Solution class for the product suggestion system problem
 */
class Solution {
    /**
     * Returns suggested products for each prefix of the search word
     * @param products Array of product names
     * @param searchWord The word to search for
     * @return List of lists containing suggested product names for each prefix
     */
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // Sort products lexicographically to ensure suggestions are in order
        Arrays.sort(products);
      
        // Build the trie with all products
        Trie trie = new Trie();
        for (int i = 0; i < products.length; i++) {
            trie.insert(products[i], i);
        }
      
        // Get product indices for each prefix of the search word
        List<Integer>[] productIndicesArray = trie.search(searchWord);
      
        // Convert indices to actual product names
        List<List<String>> suggestions = new ArrayList<>();
        for (List<Integer> indices : productIndicesArray) {
            List<String> productNames = new ArrayList<>();
            for (int productIndex : indices) {
                productNames.add(products[productIndex]);
            }
            suggestions.add(productNames);
        }
      
        return suggestions;
    }
}
