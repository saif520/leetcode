class Solution {

    /**
     * Computes the minimum sum possible between two given arrays after making sure
     * that none of the elements in the arrays are less than one.
     * It returns -1 if it is impossible to make both sums equal without the use of zeros.
     *
     * @param nums1 the first array of integers
     * @param nums2 the second array of integers
     * @return the minimum sum possible or -1 if it can't be done
     */
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0; // Initialize sum for the first array
        long sum2 = 0; // Initialize sum for the second array
        boolean hasZero = false; // Flag to check for presence of zero in nums1
      
        // Iterate over the first array
        for (int value : nums1) {
            hasZero |= value == 0; // Set the flag if zero is found
            sum1 += Math.max(value, 1); // Ensure that each value contributes at least 1 to the sum
        }
      
        // Iterate over the second array
        for (int value : nums2) {
            sum2 += Math.max(value, 1); // Ensure that each value contributes at least 1 to the sum
        }
      
        // If the sum of the first array is greater, call the function again with reversed parameters
        if (sum1 > sum2) {
            return minSum(nums2, nums1);
        }
      
        // If the sums are equal, return the sum of the first array
        if (sum1 == sum2) {
            return sum1;
        }
      
        // If there is a zero in the first array and the sums are not equal, returning the sum of the
        // second array is valid; otherwise, return -1 as it is impossible to make sums equal.
        return hasZero ? sum2 : -1;
    }
}