class Solution {
    public int maxTwoEvents(int[][] events) {
         // Sort events by start time
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        // Min-heap based on end time
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]   // a[0] = end time
        );

        int maxPrev = 0;
        int res = 0;

        for (int[] event : events) {
            int start = event[0];
            int end = event[1];
            int value = event[2];

            // Remove all events that ended before current start
            while (!pq.isEmpty() && start > pq.peek()[0]) {
                maxPrev = Math.max(maxPrev, pq.poll()[1]);
            }

            // Push current event (end, value)
            pq.offer(new int[]{end, value});

            // Update result
            res = Math.max(res, maxPrev + value);
        }

        return res;
    }
}