class Solution {

    // Determine the minimum capability to partition the array in such a way that
    // the sum of each sub-array is less than or equal to k
    public int minCapability(int[] nums, int k) {
        // Start with the least possible capability
        int left = 0;
        // Set an upper limit for the search space, assuming the max value according to problem constraints
        int right = (int) 1e9;

        // Perform a binary search to find the minimum capability
        while (left < right) {
            // Get the midpoint of the current search space
            int mid = (left + right) >> 1;

            // Check if the current capability can achieve the required partition
            if (calculatePartitionCount(nums, mid) >= k) {
                // If it qualifies, search the lower half to find a smaller capability
                right = mid;
            } else {
                // Otherwise, search the upper half
                left = mid + 1;
            }
        }

        // left is now the minimum capability that can achieve the required partition
        return left;
    }

    // Helper method to calculate the number of partitions formed by capability x
    private int calculatePartitionCount(int[] nums, int x) {
        int count = 0; // Initialize the partition count
        int lastPartitionIndex = -2; // Initialize the index of the last partition start

        // Iterate over the array
        for (int i = 0; i < nums.length; ++i) {
            // Skip if the current number exceeds the capability or is the next immediate number after the last partition
            if (nums[i] > x || i == lastPartitionIndex + 1) {
                continue;
            }
            // Increment the partition count and update lastPartitionIndex
            ++count;
            lastPartitionIndex = i;
        }

        // Return the total number of partitions that can be made with capability x
        return count;
    }
}