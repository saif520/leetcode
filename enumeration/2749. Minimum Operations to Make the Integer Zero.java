class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        // Try different values of k starting from 1
        for (long k = 1; ; k++) {
            // Calculate the target value after k operations
            // Each operation: num1 = num1 - (2^i + num2)
            // After k operations: num1 - k * num2 = sum of k powers of 2
            long targetSum = num1 - k * num2;
          
            // If target becomes negative, no solution exists for this and larger k
            if (targetSum < 0) {
                break;
            }
          
            // Check if targetSum can be represented as sum of exactly k powers of 2
            // Minimum powers needed: number of 1-bits in binary representation
            // Maximum powers possible: targetSum itself (using 2^0 = 1 repeatedly)
            // Valid if: bitCount(targetSum) <= k <= targetSum
            if (Long.bitCount(targetSum) <= k && k <= targetSum) {
                return (int) k;
            }
        }
      
        // No valid k found
        return -1;
    }
}