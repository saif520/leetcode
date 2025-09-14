class Solution {
    /**
     * Spellchecker that handles exact matches, case-insensitive matches, and vowel-error matches.
     * 
     * @param wordlist Array of valid words
     * @param queries Array of words to check
     * @return Array of corrected words (or empty string if no match found)
     */
    public String[] spellchecker(String[] wordlist, String[] queries) {
        // Set for exact match checking
        Set<String> exactWords = new HashSet<>();
      
        // Map for case-insensitive matches (lowercase -> first occurrence in wordlist)
        Map<String, String> caseInsensitiveMap = new HashMap<>();
      
        // Map for vowel-error matches (vowel pattern -> first occurrence in wordlist)
        Map<String, String> vowelPatternMap = new HashMap<>();
      
        // Build the data structures from wordlist
        for (String word : wordlist) {
            // Add to exact match set
            exactWords.add(word);
          
            // Add to case-insensitive map (only first occurrence)
            String lowercaseWord = word.toLowerCase();
            caseInsensitiveMap.putIfAbsent(lowercaseWord, word);
          
            // Add to vowel pattern map (only first occurrence)
            String vowelPattern = replaceVowelsWithWildcard(lowercaseWord);
            vowelPatternMap.putIfAbsent(vowelPattern, word);
        }
      
        // Process each query
        int queryCount = queries.length;
        String[] results = new String[queryCount];
      
        for (int i = 0; i < queryCount; i++) {
            String query = queries[i];
          
            // Priority 1: Check for exact match
            if (exactWords.contains(query)) {
                results[i] = query;
                continue;
            }
          
            // Priority 2: Check for case-insensitive match
            String lowercaseQuery = query.toLowerCase();
            if (caseInsensitiveMap.containsKey(lowercaseQuery)) {
                results[i] = caseInsensitiveMap.get(lowercaseQuery);
                continue;
            }
          
            // Priority 3: Check for vowel-error match
            String queryVowelPattern = replaceVowelsWithWildcard(lowercaseQuery);
            if (vowelPatternMap.containsKey(queryVowelPattern)) {
                results[i] = vowelPatternMap.get(queryVowelPattern);
                continue;
            }
          
            // No match found
            results[i] = "";
        }
      
        return results;
    }
  
    /**
     * Replaces all vowels in the string with wildcard character '*'.
     * 
     * @param word Input string (should be lowercase)
     * @return String with vowels replaced by '*'
     */
    private String replaceVowelsWithWildcard(String word) {
        char[] characters = word.toCharArray();
      
        for (int i = 0; i < characters.length; i++) {
            char currentChar = characters[i];
            // Check if current character is a vowel
            if (currentChar == 'a' || currentChar == 'e' || currentChar == 'i' || 
                currentChar == 'o' || currentChar == 'u') {
                characters[i] = '*';
            }
        }
      
        return String.valueOf(characters);
    }
}