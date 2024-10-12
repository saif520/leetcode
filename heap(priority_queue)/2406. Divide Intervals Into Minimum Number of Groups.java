class Solution {
    public int minGroups(int[][] intervals) {
        // Sort the intervals based on the start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
      
        // A priority queue to manage the end times of the intervals
        PriorityQueue<Integer> endTimeQueue = new PriorityQueue<>();
      
        // Iterate over all intervals
        for (int[] interval : intervals) {
            // If the queue is not empty and the smallest end time is less than the
            // start of the current interval, we can reuse this group for the new interval
            if (!endTimeQueue.isEmpty() && endTimeQueue.peek() < interval[0]) {
                endTimeQueue.poll(); // Remove the interval with the smallest end time
            }
          
            // Add the current interval's end time to the queue
            endTimeQueue.offer(interval[1]);
        }
      
        // The size of the priority queue indicates the minimum number of groups needed
        return endTimeQueue.size();
    }
}