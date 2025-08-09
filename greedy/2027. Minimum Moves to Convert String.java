class Solution {
    public int minimumMoves(String s) {
        int moves = 0; // Initialize the count of moves to 0
      
        // Loop over the string, increment the loop counter accordingly
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'X') {
                moves++;  // If the current character is 'X', increment the move count
                i += 2;   // Skip the next two characters since one move can change up to 3 consecutive characters
            }
        }
      
        return moves; // Return the total number of moves required
    }
}