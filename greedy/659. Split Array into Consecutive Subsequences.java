class Solution {
    public boolean isPossible(int[] nums) {
        // Map to store ending number -> priority queue of subsequence lengths ending at that number
        // Priority queue keeps shortest subsequence length at the top (min heap)
        Map<Integer, PriorityQueue<Integer>> endingNumberToLengths = new HashMap<>();
      
        // Process each number in the input array
        for (int currentNum : nums) {
            // Check if there's a subsequence ending at (currentNum - 1) that we can extend
            if (endingNumberToLengths.containsKey(currentNum - 1)) {
                // Get the priority queue of subsequences ending at (currentNum - 1)
                PriorityQueue<Integer> previousQueue = endingNumberToLengths.get(currentNum - 1);
              
                // Remove the shortest subsequence and extend it by 1
                int shortestLength = previousQueue.poll();
              
                // Add the extended subsequence to subsequences ending at currentNum
                endingNumberToLengths.computeIfAbsent(currentNum, k -> new PriorityQueue<>())
                    .offer(shortestLength + 1);
              
                // Clean up: remove entry if no more subsequences end at (currentNum - 1)
                if (previousQueue.isEmpty()) {
                    endingNumberToLengths.remove(currentNum - 1);
                }
            } else {
                // No subsequence to extend, start a new subsequence of length 1
                endingNumberToLengths.computeIfAbsent(currentNum, k -> new PriorityQueue<>())
                    .offer(1);
            }
        }
      
        // Check if all subsequences have length at least 3
        for (PriorityQueue<Integer> lengths : endingNumberToLengths.values()) {
            // If the shortest subsequence is less than 3, return false
            if (lengths.peek() < 3) {
                return false;
            }
        }
      
        // All subsequences have valid length (>= 3)
        return true;
    }
}
