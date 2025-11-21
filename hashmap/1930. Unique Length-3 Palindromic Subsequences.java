class Solution {
    public int countPalindromicSubsequence(String s) {
        // Store first and last index of each character
        int[][] mp = new int[26][2];

        // Initialize with -1
        for (int i = 0; i < 26; i++) {
            mp[i][0] = -1; // first occurrence
            mp[i][1] = -1; // last occurrence
        }

        int n = s.length();

        // First occurrence
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            if (mp[idx][0] == -1) {
                mp[idx][0] = i;
            }
        }

        // Last occurrence
        for (int i = n - 1; i >= 0; i--) {
            int idx = s.charAt(i) - 'a';
            if (mp[idx][1] == -1) {
                mp[idx][1] = i;
            }
        }

        int ans = 0;

        // For each character, count unique middle characters
        for (int c = 0; c < 26; c++) {
            int start = mp[c][0];
            int end = mp[c][1];

            if (start == -1 || end == -1 || start >= end) continue;

            HashSet<Character> set = new HashSet<>();

            for (int i = start + 1; i < end; i++) {
                set.add(s.charAt(i));
            }

            ans += set.size();
        }

        return ans;
    }
}
