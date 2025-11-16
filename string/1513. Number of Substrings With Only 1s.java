class Solution {
    public int numSub(String s) {
        long MOD = 1000000007;
        long res = 0;
        long consecutive = 0;

        for (char c : s.toCharArray()) {
            if (c == '1') {
                consecutive++;
                res = (res + consecutive) % MOD;
            } else {
                consecutive = 0;
            }
        }

        return (int) res;
    }
}
