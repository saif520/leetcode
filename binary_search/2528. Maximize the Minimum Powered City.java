class Solution {
    public long maxPower(int[] stations, int r, int k) {
        long low = 0;
        long high = k;
        long ans = 0;
        int n = stations.length;

        for (int i = 0; i < n; i++) {
            high += stations[i];
        }

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (isPossible(mid, stations, r, k)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean isPossible(long mid, int[] stations, int r, long k) {
        long sum = 0;
        int n = stations.length;
        int[] temp = stations.clone(); // Clone to avoid modifying original array

        // Initialize sliding window
        for (int i = 0; i < r && i < n; i++) {
            sum += temp[i];
        }

        for (int i = 0; i < n; i++) {
            if (i + r < n) {
                sum += temp[i + r];
            }
            if (i - (r + 1) >= 0) {
                sum -= temp[i - (r + 1)];
            }

            if (sum < mid) {
                long need = mid - sum;
                if (need > k) {
                    return false;
                }

                if (i + r < n) {
                    temp[i + r] += need;
                } else {
                    temp[n - 1] += need; // Add to last station if out of range
                }
                k -= need;
                sum = mid;
            }
        }

        return true;
    }
}
