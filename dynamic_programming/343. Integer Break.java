class Solution {
    public int integerBreak(int n) {
        // If n is less than 4, the maximum product is n - 1
        if (n < 4) {
            return n - 1;
        }
      
        // If n is a multiple of 3, the maximum product is 3 raised to the power of (n divided by 3)
        if (n % 3 == 0) {
            return (int) Math.pow(3, n / 3);
        }
      
        // If n modulo 3 gives remainder 1, we use one 4 (as 2*2) and the rest as 3s
        if (n % 3 == 1) {
            return (int) Math.pow(3, (n / 3) - 1) * 4;
        }
      
        // If n modulo 3 gives remainder 2, we use one 2 and the rest as 3s
        return (int) Math.pow(3, n / 3) * 2;
    }
}