import java.util.ArrayList;
import java.util.List;

class Solution {
    private final List<List<Integer>> combinations = new ArrayList<>();
    private final List<Integer> currentCombination = new ArrayList<>();
    private int totalNumbers;
    private int combinationSize;

    // Generates all combinations of numbers of size k from a set of numbers from 1 to n.
    public List<List<Integer>> combine(int n, int k) {
        totalNumbers = n;
        combinationSize = k;
        backtrack(1); // Start the backtracking algorithm from the first element
        return combinations;
    }

    // Uses backtracking to find all combinations.
    private void backtrack(int startIndex) {
        // If the current combination's size is equal to the desired size,
        // add it to the list of combinations.
        if (currentCombination.size() == combinationSize) {
            combinations.add(new ArrayList<>(currentCombination));
            return;
        }
      
        // If the index has gone beyond the last number, end the current path.
        if (startIndex > totalNumbers) {
            return;
        }
      
        // Include the current number in the combination and move to the next number.
        currentCombination.add(startIndex);
        backtrack(startIndex + 1);

        // Exclude the current number from the combination and move to the next number.
        currentCombination.remove(currentCombination.size() - 1);
        backtrack(startIndex + 1);
    }
}