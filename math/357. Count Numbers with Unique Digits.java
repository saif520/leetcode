class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        // If n is 0, there's only one number which is 0 itself
        if (n == 0) {
            return 1;
        }
      
        // If n is 1, we have digits from 0 to 9, resulting in 10 unique numbers
        if (n == 1) {
            return 10;
        }
      
        // Initialize answer with the count for n = 1
        int answer = 10;
      
        // Current number of unique digits as we increase the length
        int currentUniqueNumbers = 9;
      
        // Loop to calculate the number of unique digit numbers for lengths 2 to n
        for (int i = 0; i < n - 1; ++i) {
            // Compute the count for the current length by multiplying with the digits
            // available considering we can't reuse any we have already used
            currentUniqueNumbers *= (9 - i);
          
            // Add the current length's count to the total answer so far
            answer += currentUniqueNumbers;
        }
      
        // Return the total count of unique numbers with digits up to length n
        return answer;
    }
}