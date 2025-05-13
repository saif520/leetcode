class Solution {
    private static final int MOD = 1_000_000_007;

    public int lengthAfterTransformations(String s, int t) {
        // count[i] = number of characters of 'a'+i
        long[] count = new long[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        while (t-- > 0) {
            long[] next = new long[26];
            for (int i = 0; i < 25; i++) {
                // all letters except 'z' move to the next letter
                next[i + 1] = (next[i + 1] + count[i]) % MOD;
            }
            // 'z' becomes 'a' and 'b'
            next[0] = (next[0] + count[25]) % MOD;
            next[1] = (next[1] + count[25]) % MOD;

            count = next;
        }

        long result = 0;
        for (long val : count) {
            result = (result + val) % MOD;
        }
        return (int) result;
    }
}
