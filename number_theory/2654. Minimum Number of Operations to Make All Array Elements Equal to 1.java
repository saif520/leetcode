import java.util.*;

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int ones = 0;
        
        // Step 1: Count how many 1's already present
        for (int num : nums) {
            if (num == 1) ones++;
        }
        
        // If already have ones, we just need to convert others
        if (ones > 0) return n - ones;
        
        // Step 2: Find shortest subarray with GCD = 1
        int minLen = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            int g = nums[i];
            for (int j = i + 1; j < n; j++) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    minLen = Math.min(minLen, j - i + 1);
                    break; // no need to expand further
                }
            }
        }
        
        // Step 3: If no subarray gives GCD 1, impossible
        if (minLen == Integer.MAX_VALUE) return -1;
        
        // Step 4: Total operations = (minLen - 1) + (n - 1)
        return (minLen - 1) + (n - 1);
    }
    
    // Helper function to calculate gcd
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
