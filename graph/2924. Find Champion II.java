class Solution {
    public int findChampion(int n, int[][] edges) {
         // Array to store the incoming degree count for each node
        int[] incomingDegreeCounts = new int[n];

        // Loop through all edges to calculate the incoming degree counts
        for (int[] edge : edges) {
            // Increment the count of incoming edges for the destination node
            incomingDegreeCounts[edge[1]]++;
        }

        // Variable to store the champion node index, initialized as -1 (not found)
        int champion = -1;
        // Counter to keep track of how many nodes have zero incoming edges
        int zeroIncomingCount = 0;

        // Loop through all nodes to find the champion node
        for (int i = 0; i < n; ++i) {
            // Check if the current node has zero incoming edges
            if (incomingDegreeCounts[i] == 0) {
                // Increment the counter for nodes with zero incoming edges
                zeroIncomingCount++;
                // Set the current node as the potential champion
                champion = i;
            }
        }

        // Check if there is exactly one node with zero incoming edges
        // If so, return the index of the champion node; otherwise, return -1
        return zeroIncomingCount == 1 ? champion : -1;
    }
}