class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
         // This array holds the count of normalized representations of dominoes.
        int[] count = new int[100];
        int numberOfPairs = 0; // This will store the total number of equivalent domino pairs.
      
        // Loop through each domino in the array of dominoes.
        for (int[] domino : dominoes) {
            int lesserValue = Math.min(domino[0], domino[1]); // Find the lesser value of the two sides of the domino.
            int greaterValue = Math.max(domino[0], domino[1]); // Find the greater value of the two sides of the domino.

            // Normalize the representation of the domino so that the
            // lesser value comes first (e.g., [2,1] becomes [1,2]).
            int normalizedDomino = lesserValue * 10 + greaterValue;

            // If this normalized domino has been seen before, increment the number of pairs
            // by the count of how many times the same domino has been encountered. Then,
            // increment the count for this domino type.
            numberOfPairs += count[normalizedDomino]++;
        }

        return numberOfPairs; // Return the total count of equivalent domino pairs.
    }
}