class Solution {
    // Repair cars by using ranks of mechanics to calculate the minimum time.
    public long repairCars(int[] ranks, int totalCars) {
        long low = 0; // Set the lower bound of the search space to 0.
        // Set the upper bound of the search space:
        // the product of the maximum rank, total number of cars and total cars squared.
        long high = 1L * ranks[0] * totalCars * totalCars;
      
        // Implement binary search to find the minimum amount of time needed.
        while (low < high) {
            long mid = (low + high) >> 1; // Find the midpoint between low and high.
            long count = 0; // Initialize count of cars that can be repaired in 'mid' time.
          
            // Calculate the number of cars each mechanic can fix in 'mid' time.
            for (int rank : ranks) {
                count += Math.sqrt(mid / rank);
            }
          
            // If count is at least equal to the total number of cars,
            // we could potentially reduce the high to mid.
            if (count >= totalCars) {
                high = mid;
            } else {
                // Otherwise, we have to increase the low to mid + 1 to find the minimum time.
                low = mid + 1;
            }
        }
      
        // When low meets high, we've found the minimum time needed for the repairs.
        return low;
    }
}