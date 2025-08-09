class Solution {

    private static final int MAX_NODES = 110; // assuming the maximum number of nodes is 110
    private static final int INFINITY = 0x3f3f3f3f; // represent an infinite distance value

    // Calculates the time it takes for all nodes to receive the signal from node k
    public int networkDelayTime(int[][] times, int n, int k) {
        // Initialize the graph with distances set to infinity
        int[][] graph = new int[MAX_NODES][MAX_NODES];
        for (int i = 0; i < MAX_NODES; ++i) {
            Arrays.fill(graph[i], INFINITY);
        }
      
        // Fill the graph with input times
        for (int[] edge : times) {
            graph[edge[0]][edge[1]] = edge[2];
        }

        // Initialize distances from source (node k) to all nodes as infinite
        int[] distances = new int[MAX_NODES];
        Arrays.fill(distances, INFINITY);
        // Distance to the source node itself is always 0
        distances[k] = 0;

        // Keep track of visited nodes
        boolean[] visited = new boolean[MAX_NODES];

        // Perform Dijkstra's algorithm to find shortest paths from node k
        for (int i = 0; i < n; ++i) {
            int currentNode = -1;
            // Find the unvisited node with the smallest distance
            for (int j = 1; j <= n; ++j) {
                if (!visited[j] && (currentNode == -1 || distances[currentNode] > distances[j])) {
                    currentNode = j;
                }
            }
            // Mark this node as visited
            visited[currentNode] = true;

            // Update distances to neighboring nodes of the current node
            for (int j = 1; j <= n; ++j) {
                distances[j] = Math.min(distances[j], distances[currentNode] + graph[currentNode][j]);
            }
        }

        // Find the maximum distance from the source node to all nodes
        int answer = 0;
        for (int i = 1; i <= n; ++i) {
            answer = Math.max(answer, distances[i]);
        }

        // If the maximum distance is INFINITY, not all nodes are reachable
        return answer == INFINITY ? -1 : answer;
    }
}