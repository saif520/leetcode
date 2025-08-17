class Solution {

    private int[] nums;      // Array to store the current state (which can be shuffled)
    private int[] original;  // Array to store the original state
    private Random rand;     // Random number generator

    // Constructor that takes an array of integers.
    // The incoming array represents the initial state.
    public Solution(int[] nums) {
        this.nums = nums; // Initialize current state with the incoming array
        this.original = Arrays.copyOf(nums, nums.length); // Copy the original array
        this.rand = new Random(); // Instantiate the Random object
    }

    // This method resets the array to its original configuration and returns it.
    public int[] reset() {
        // Restore the original state of array
        nums = Arrays.copyOf(original, original.length);
        return nums;
    }

    // This method returns a random shuffling of the array.
    public int[] shuffle() {
        // Loop over the array elements
        for (int i = 0; i < nums.length; ++i) {
            // Swap the current element with a randomly selected element from the remaining
            // portion of the array, starting at the current index to the end of the array.
            swap(i, i + rand.nextInt(nums.length - i));
        }
        // Return the shuffled array
        return nums;
    }

    // Helper method to swap two elements in the array.
    // Takes two indices and swaps the elements at these indices.
    private void swap(int i, int j) {
        int temp = nums[i]; // Temporary variable to hold the value of the first element
        nums[i] = nums[j]; // Assign the value of the second element to the first
        nums[j] = temp;    // Assign the value of the temporary variable to the second
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */