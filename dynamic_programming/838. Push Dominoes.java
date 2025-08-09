class Solution {
    public String pushDominoes(String dominoes) {
       int length = dominoes.length();
        // Queue to keep track of indices in the dominoes string that are affected by forces
        Deque<Integer> queue = new ArrayDeque<>();
        // Array to keep track of the time when each force reaches an index
        int[] times = new int[length];
        // Initialize all times to -1 (indicating no force has reached the index)
        Arrays.fill(times, -1);
        // List to store forces affecting each index (as multiple forces can affect the same index)
        List<Character>[] forces = new List[length];
        for (int i = 0; i < length; ++i) {
            forces[i] = new ArrayList<>();
        }
      
        // Initialize the forces and times with the initial state. Also add indices to queue to process
        for (int i = 0; i < length; ++i) {
            char force = dominoes.charAt(i);
            if (force != '.') {
                queue.offer(i);
                times[i] = 0;
                forces[i].add(force);
            }
        }
      
        // Array to store the final state of the dominoes
        char[] result = new char[length];
        Arrays.fill(result, '.');
      
        // Process the queue until it is empty
        while (!queue.isEmpty()) {
            int idx = queue.poll();
            // If only one force is affecting the index, update the result
            if (forces[idx].size() == 1) {
                char force = forces[idx].get(0);
                result[idx] = force;
                int nextIdx = force == 'L' ? idx - 1 : idx + 1;
                if (nextIdx >= 0 && nextIdx < length) {
                    int currentTime = times[idx];
                    if (times[nextIdx] == -1) {
                        queue.offer(nextIdx);
                        times[nextIdx] = currentTime + 1;
                        forces[nextIdx].add(force);
                    } else if (times[nextIdx] == currentTime + 1) {
                        forces[nextIdx].add(force);
                    }
                }
            }
        }
      
        // Convert char array to string and return
        return new String(result); 
    }
}