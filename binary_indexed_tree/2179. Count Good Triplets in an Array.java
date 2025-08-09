class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int length = nums1.length;
        // Array to hold the positions of elements of nums2 w.r.t nums1
        int[] positions = new int[length];
        // Initialize the binary indexed tree with size 'length'
        BinaryIndexedTree bit = new BinaryIndexedTree(length);
        // Fill the positions array with the current positions of elements from nums2
        for (int i = 0; i < length; ++i) {
            positions[nums2[i]] = i + 1;
        }
      
        long totalGoodTriplets = 0; // This will hold the answer - the total number of good triplets
      
        // Traverse each element in nums1
        for (int number : nums1) {
            int position = positions[number];
            // The number of elements less than the current number in nums2
            long leftCount = bit.query(position);
            // The number of elements greater than the current number in nums2
            long rightCount = length - position - (bit.query(length) - bit.query(position));
            // Multiply left count and right count to get the number of good triplets for current number
            totalGoodTriplets += leftCount * rightCount;
            // Update the binary indexed tree
            bit.update(position, 1);
        }
        return totalGoodTriplets;
    }
}

class BinaryIndexedTree {
    private int size; // The size of binary indexed tree
    private int[] tree; // The binary indexed tree data structure

    public BinaryIndexedTree(int size) {
        this.size = size;
        tree = new int[size + 1];
    }

    // Method to update the tree with value 'delta' at index 'index'
    public void update(int index, int delta) {
        while (index <= size) {
            tree[index] += delta;
            index += lowbit(index); // Find next index to update
        }
    }

    // Method to query the cumulative frequency up until index 'index'
    public int query(int index) {
        int sum = 0;
        while (index > 0) {
            sum += tree[index];
            index -= lowbit(index); // Move to the previous index to query sum
        }
        return sum;
    }

    // Utility method to get the least significant bit
    public static int lowbit(int value) {
        return value & -value;
    }
}
Time and