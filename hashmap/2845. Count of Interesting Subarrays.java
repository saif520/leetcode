class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        int totalCount = nums.size(); // Total number of elements in nums
        int[] remainders = new int[totalCount]; // Array to store the remainders

        // Populate the remainders array with 1 if nums[i] % modulo == k or with 0 otherwise
        for (int i = 0; i < totalCount; i++) {
            remainders[i] = nums.get(i) % modulo;
            if (remainders[i] == k) {
                remainders[i] = 1;
            } else {
                remainders[i] = 0;
            }
        }

        Map<Integer, Integer> remainderCounts = new HashMap<>(); // Map to store the remainder frequencies
        remainderCounts.put(0, 1); // Initialize with 0 remainder seen once
        long interestingSubarraysCount = 0; // Variable to hold the final count of interesting subarrays
        int sum = 0; // Variable to accumulate the sum of remainders

        // Iterate over the remainders array
        for (int remainder : remainders) {
            sum += remainder; // Increase the sum with the current remainder
            // Increase the count by the number of occurrences where the adjusted sum matches the expected remainder
            interestingSubarraysCount += remainderCounts.getOrDefault((sum - k + modulo) % modulo, 0);
            // Update the map with the current modulus of the sum and increase the count by 1 or set it to 1 if not present
            remainderCounts.merge(sum % modulo, 1, Integer::sum);
        }

        return interestingSubarraysCount; // Return the count of interesting subarrays
    }
}