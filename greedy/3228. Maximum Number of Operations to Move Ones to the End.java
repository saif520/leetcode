class Solution {
    public int maxOperations(String s) {
        // Reverse the string
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        s = sb.toString();

        int n = s.length();
        int startIndex = n;

        // Find the first '0' from the left (after reversing)
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                startIndex = i;
                break;
            }
        }

        int impact = 1, ans = 0;

        for (int i = startIndex; i < n; i++) {
            if (s.charAt(i) == '0') continue;

            int ct = 0;
            int j = i;

            while (j < n && s.charAt(j) == '1') {
                ct++;
                j++;
            }

            ans += ct * impact;
            impact++;
            i = j - 1;
        }

        return ans;
    }
}
