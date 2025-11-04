class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            // Step 1: Count frequencies in current subarray
            HashMap<Integer, Integer> freqMap = new HashMap<>();
            for (int j = i; j < i + k; j++) {
                freqMap.put(nums[j], freqMap.getOrDefault(nums[j], 0) + 1);
            }

            // Step 2: Build priority queue sorted by frequency desc, value desc
            PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (!a.getValue().equals(b.getValue()))
                        return b.getValue() - a.getValue();
                    else
                        return b.getKey() - a.getKey();
                }
            );
            pq.addAll(freqMap.entrySet());

            // Step 3: Take top x elements and calculate sum
            int sum = 0;
            int count = 0;
            while (!pq.isEmpty() && count < x) {
                Map.Entry<Integer, Integer> entry = pq.poll();
                sum += entry.getKey() * entry.getValue();
                count++;
            }

            ans[i] = sum;
        }

        return ans;
    }
}