class Solution {
    private int totalXor;               // Holds the xor of all elements in nums
    private int subtreeXor;             // Xor value of a subtree
    private int nodeCount;              // Holds the number of nodes in the graph/tree
    private int minimumScore = Integer.MAX_VALUE; // The minimum score we intend to find
    private int[] nodeValues;           // Holds the values at the nodes
    private List<Integer>[] graph;      // The graph represented as an adjacency list

    public int minimumScore(int[] nums, int[][] edges) {
        nodeCount = nums.length;
        graph = new List[nodeCount];
        nodeValues = nums;
        // Initialize lists for all graph nodes
        Arrays.setAll(graph, k -> new ArrayList<>());
        // Construct the graph from the edge list
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            graph[from].add(to);
            graph[to].add(from);
        }
        // Compute the xor of all values in nums
        for (int value : nums) {
            totalXor ^= value;
        }
        // Try cutting from each edge and calculate minimum score
        for (int i = 0; i < nodeCount; ++i) {
            for (int adjacentNode : graph[i]) {
                // Perform the first DFS to find the xor of a subtree
                subtreeXor = firstDfs(i, -1, adjacentNode);
                // Perform the second DFS to determine the minimum score possible
                secondDfs(i, -1, adjacentNode);
            }
        }
        return minimumScore;
    }

    private int firstDfs(int node, int parent, int excludedNode) {
        int result = nodeValues[node];
        // Traverse the children (excluding the parent and the excluded node)
        for (int child : graph[node]) {
            if (child != parent && child != excludedNode) {
                result ^= firstDfs(child, node, excludedNode);
            }
        }
        return result;
    }

    private int secondDfs(int node, int parent, int excludedNode) {
        int result = nodeValues[node];
        // Traverse the children (excluding the parent and the excluded node)
        for (int child : graph[node]) {
            if (child != parent && child != excludedNode) {
                // Calculate xor for this subtree
                int subtreeResult = secondDfs(child, node, excludedNode);
                result ^= subtreeResult;
                // Partition the graph into 3 parts and find the score
                int firstPart = subtreeResult;
                int secondPart = subtreeXor ^ firstPart;
                int thirdPart = totalXor ^ subtreeXor;
                // Calculate the temporary score
                int score = Math.max(Math.max(firstPart, secondPart), thirdPart) 
                          - Math.min(Math.min(firstPart, secondPart), thirdPart);
                // Update the minimum score if we found a better one
                minimumScore = Math.min(minimumScore, score);
            }
        }
        return result;
    }
}