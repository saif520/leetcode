
class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        // Step 1: Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= c; i++) graph.add(new ArrayList<>());
        for (int[] e : connections) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        // Step 2: DFS to find connected components
        int[] compId = new int[c + 1];
        int compCount = 0;
        for (int i = 1; i <= c; i++) {
            if (compId[i] == 0) {
                compCount++;
                dfs(i, compCount, graph, compId);
            }
        }

        // Step 3: Map each component → TreeSet of online stations
        Map<Integer, TreeSet<Integer>> compMap = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            compMap.computeIfAbsent(compId[i], k -> new TreeSet<>()).add(i);
        }

        // Step 4: Track online/offline status
        boolean[] online = new boolean[c + 1];
        Arrays.fill(online, true);

        // Step 5: Process queries
        List<Integer> ans = new ArrayList<>();
        for (int[] q : queries) {
            int type = q[0];
            int x = q[1];
            int comp = compId[x];

            if (type == 1) {
                // maintenance query
                if (online[x]) ans.add(x);
                else {
                    TreeSet<Integer> set = compMap.get(comp);
                    if (set.isEmpty()) ans.add(-1);
                    else ans.add(set.first());
                }
            } else {
                // type == 2: make offline
                if (online[x]) {
                    online[x] = false;
                    compMap.get(comp).remove(x);
                }
            }
        }

        // Step 6: Convert result list to array
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) res[i] = ans.get(i);
        return res;
    }

    private void dfs(int node, int compIdNum, List<List<Integer>> graph, int[] compId) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        compId[node] = compIdNum;

        while (!stack.isEmpty()) {
            int u = stack.pop();
            for (int v : graph.get(u)) {
                if (compId[v] == 0) {
                    compId[v] = compIdNum;
                    stack.push(v);
                }
            }
        }
    }
}