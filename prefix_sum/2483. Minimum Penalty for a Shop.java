class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();

        int[] prefixN = new int[n + 1];
        int[] suffixY = new int[n + 1];

        // prefixN[i] = number of 'N' in [0..i-1]
        for (int i = 0; i < n; i++) {
            prefixN[i + 1] = prefixN[i] + (customers.charAt(i) == 'N' ? 1 : 0);
        }

        // suffixY[i] = number of 'Y' in [i..n-1]
        for (int i = n - 1; i >= 0; i--) {
            suffixY[i] = suffixY[i + 1] + (customers.charAt(i) == 'Y' ? 1 : 0);
        }

        for(int i=0;i<prefixN.length;i++){
            System.out.print(prefixN[i]+" ");
        }

        System.out.println();
        for(int i=0;i<prefixN.length;i++){
            System.out.print(suffixY[i]+" ");
        }

        int minPenalty = Integer.MAX_VALUE;
        int bestHour = 0;

        for (int j = 0; j <= n; j++) {
            int penalty = prefixN[j] + suffixY[j];
            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = j;
            }
        }

        return bestHour;
    }
}
