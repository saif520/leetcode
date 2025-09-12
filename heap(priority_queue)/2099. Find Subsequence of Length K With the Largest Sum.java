class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
      
        // Create an array of indices [0, 1, 2, ..., n-1]
        Integer[] indices = new Integer[n];
        Arrays.setAll(indices, i -> i);
      
        // Sort indices based on their corresponding values in nums (ascending order)
        // After sorting, the last k indices will point to the k largest elements
        Arrays.sort(indices, (i, j) -> nums[i] - nums[j]);
      
        // Sort the last k indices by their original position to maintain relative order
        // This ensures the subsequence maintains the original order from nums
        Arrays.sort(indices, n - k, n);
      
        // Build the result array using the k largest elements in their original order
        int[] result = new int[k];
        for (int i = n - k; i < n; i++) {
            result[i - (n - k)] = nums[indices[i]];
        }
      
        return result;
    }
}