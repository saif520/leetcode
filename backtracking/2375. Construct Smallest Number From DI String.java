class Solution {
    // Array to keep track of visited digits
    private boolean[] visited = new boolean[10];
    // StringBuilder to construct the sequence incrementally
    private StringBuilder sequence = new StringBuilder();
    // String to store the given pattern
    private String pattern;
    // String to store the final answer sequence
    private String answer;

    public String smallestNumber(String pattern) {
        this.pattern = pattern;
        // Starting the depth-first search (DFS)
        dfs(0);
        // Return the final answer sequence
        return answer;
    }

    // Helper method for the DFS
    private void dfs(int position) {
        // If an answer is already found, stop the recursion
        if (answer != null) {
            return;
        }
        // If the length of sequence equals the length of pattern + 1, we have a complete sequence
        if (position == pattern.length() + 1) {
            // Set the current sequence as the answer
            answer = sequence.toString();
            return; // Stop further recursion
        }
        // Iterate through all possible digits (1 to 9)
        for (int i = 1; i < 10; ++i) {
            // If the current digit i has not been used yet
            if (!visited[i]) {
                // If the last added digit should be less according to the pattern 'I'
                if (position > 0 && pattern.charAt(position - 1) == 'I' && sequence.charAt(position - 1) - '0' >= i) {
                    continue; // Skip this digit since it would break the pattern
                }
                // If the last added digit should be more according to the pattern 'D'
                if (position > 0 && pattern.charAt(position - 1) == 'D' && sequence.charAt(position - 1) - '0' <= i) {
                    continue; // Skip this digit since it would break the pattern
                }
                // Mark the digit as used
                visited[i] = true;
                // Add the digit to the sequence
                sequence.append(i);
                // Recurse to the next position with updated sequence and visited digits
                dfs(position + 1);
                // Backtrack: remove the last digit from the sequence
                sequence.deleteCharAt(sequence.length() - 1);
                // Mark the digit as not used (undo the previous marking)
                visited[i] = false;
            }
        }
    }
}