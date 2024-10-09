class Solution {
    public int minAddToMakeValid(String s) {
        int additionsRequired = 0; // Count of parentheses to add to make the string valid
        int balanceCount = 0;      // Keep track of the balance between opening and closing brackets
      
        // Loop through each character in the string
        for (char character : s.toCharArray()) {
            if (character == '(') {
                // An opening parenthesis increments the balance count
                balanceCount++;
            } else if (balanceCount > 0) {
                // A closing parenthesis decrements the balance count if there are unmatched opening ones
                balanceCount--;
            } else {
                // If there are no unmatched opening, we need an opening parenthesis
                additionsRequired++;
            }
        }
      
        // Add the remaining unmatched opening parentheses to the count of required additions
        additionsRequired += balanceCount;
      
        // Return the total number of additions required to make the string valid
        return additionsRequired;
    }
}