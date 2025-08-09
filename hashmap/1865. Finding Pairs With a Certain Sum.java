import java.util.HashMap;
import java.util.Map;

// Class to find count of pairs from two arrays that sum up to a given value
class FindSumPairs {
    // Arrays to store the two input integer arrays
    private int[] nums1;
    private int[] nums2;
    // Map to keep the frequency count of elements in the second array
    private Map<Integer, Integer> frequencyMap = new HashMap<>();

    // Constructor initializes the class with two integer arrays
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
      
        // Populating the frequency map with the count of each number in nums2
        for (int value : nums2) {
            frequencyMap.put(value, frequencyMap.getOrDefault(value, 0) + 1);
        }
    }

    // Method that increments an element of nums2 at a given index by a given value
    public void add(int index, int value) {
        // Obtain the original value at the given index in nums2
        int originalValue = nums2[index];
        // Decrement the frequency of the original value in the frequency map
        frequencyMap.put(originalValue, frequencyMap.get(originalValue) - 1);
        // Increment the original value by the given value and update in nums2
        nums2[index] += value;
        // Increment the frequency of the new value in the frequency map
        frequencyMap.put(nums2[index], frequencyMap.getOrDefault(nums2[index], 0) + 1);
    }

    // Method that counts the pairs across nums1 and nums2 that sum up to a given total
    public int count(int total) {
        int count = 0;
        // Iterate through each value in nums1
        for (int value : nums1) {
            // For the current value in nums1, check if there's a complement in nums2 that sums up to total
            count += frequencyMap.getOrDefault(total - value, 0);
        }
        // Return the count of such pairs
        return count;
    }
}

/*
 * The usage of the FindSumPairs class:
 *
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index, value);
 * int result = obj.count(total);
 */