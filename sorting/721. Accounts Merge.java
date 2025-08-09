public class Solution {

    // Parent array for storing the parent index of each disjoint set (union-find)
    private int[] parent;

    // Function to find the disjoint parent of a node
    private int find(int x) {
        if (parent[x] != x) {
            // Path compression - Directly attaching x node to its root parent
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    // The main method for merging accounts
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        parent = new int[n];

        // Initialize the parent array with each node as its own parent
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // Map to store the account index for a unique email
        Map<String, Integer> emailToIndex = new HashMap<>();

        // Iterate over accounts to find and union the emails
        for (int i = 0; i < n; i++) {
            List<String> currentAccount = accounts.get(i);
            for (int j = 1; j < currentAccount.size(); j++) {
                String email = currentAccount.get(j);
                if (emailToIndex.containsKey(email)) {
                    // Perform union operation by setting the parent
                    parent[find(i)] = find(emailToIndex.get(email));
                } else {
                    // If the email is unique, map it to the current account index
                    emailToIndex.put(email, i);
                }
            }
        }

        // Map to combine emails that belong to the same owner
        Map<Integer, Set<String>> mergedAccounts = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                // Find the set's root and add the email
                int root = find(i);
                if (!mergedAccounts.containsKey(root)) {
                    mergedAccounts.put(root, new TreeSet<String>());
                }
                mergedAccounts.get(root).add(email);
            }
        }

        // Convert the sets of emails back to the required output format
        List<List<String>> result = new ArrayList<>();
        for (Integer i : mergedAccounts.keySet()) {
            List<String> account = new ArrayList<>();
            account.add(accounts.get(i).get(0)); // Add the account name
            account.addAll(mergedAccounts.get(i)); // Add all merged emails
            result.add(account); // Add to final results
        }

        return result;
    }
}