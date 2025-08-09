class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length;  // Length of the colors array
        int ans = 0;  // Counter for the number of valid alternating groups
        int cnt = 0;  // Counter for the current group length

        // Loop through twice the length of the array to handle circular groups
        for (int i = 0; i < n << 1; ++i) {
            // Check if the current color is the same as the previous one
            if (i > 0 && colors[i % n] == colors[(i - 1) % n]) {
                cnt = 1; // Reset group length if current color is the same as previous
            } else {
                ++cnt; // Increment group length as colors are alternating
            }
            // After the first full pass through the array, check if the group length is at least k
            if (i >= n && cnt >= k) {
                ans++; // If valid group of length k or more, increment answer
            }
        }
        return ans; // Return the total number of valid groups
    }
}