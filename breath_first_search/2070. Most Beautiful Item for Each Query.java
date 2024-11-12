class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        // Sort the items array based on the price in increasing order
        Arrays.sort(items, (item1, item2) -> item1[0] - item2[0]);

        // Update the beauty value in the sorted items array to ensure that each
        // item has the maximum beauty value at or below its price.
        for (int i = 1; i < items.length; ++i) {
            // The current maximum beauty is either the beauty of the current item
            // or the maximum beauty of all previous items.
            items[i][1] = Math.max(items[i - 1][1], items[i][1]);
        }

        // The number of queries to process
        int queryCount = queries.length;
        // Array to store the answer for each query
        int[] answers = new int[queryCount];

        // Process each query to find the maximum beauty for the specified price
        for (int i = 0; i < queryCount; ++i) {
            // Use binary search to find the rightmost item with a price not
            // exceeding the query (price we can spend).
            int left = 0, right = items.length;
            while (left < right) {
                int mid = (left + right) >> 1; // equivalent to (left + right) / 2
                if (items[mid][0] > queries[i]) {
                    // If the mid item's price exceeds the query price, move the right pointer
                    right = mid;
                } else {
                    // Otherwise, move the left pointer to continue searching to the right
                    left = mid + 1;
                }
            }

            // If there's at least one item that costs less than or equal to the query price
            if (left > 0) {
                // The answer is the maximum beauty found among all the affordable items
                answers[i] = items[left - 1][1];
            }
            // If no such item is found, the default answer of 0 (for beauty) will remain
        }

        // Return the array of answers for all the queries
        return answers;
    }
}