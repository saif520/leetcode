class Solution {
    // Method to find which receiver will get the laser signal
    public int mirrorReflection(int p, int q) {
        // Calculate the greatest common divisor of p and q
        int gcdValue = greatestCommonDivisor(p, q);
      
        // Even p means the laser hits the east wall (return 2)
        // Odd p means the laser hits the north/south wall
        // Odd q means the laser is at a corner position (return 1)
        // Even q means the laser is at the 0th receiver

        // Simplify the problem by dividing p and q by their gcd
        // and taking the parity (even or odd) of the result
        p = (p / gcdValue) % 2;
        q = (q / gcdValue) % 2;
      
        // If both p and q are odd, the laser will meet at receiver 1
        if (p == 1 && q == 1) {
            return 1;
        }
        // If p is odd and q is even, the laser will meet at receiver 0
        // If p is even and q is odd, the laser will meet at receiver 2
        return p == 1 ? 0 : 2;
    }

    // Helper method to calculate the greatest common divisor using the Euclidean algorithm
    private int greatestCommonDivisor(int a, int b) {
        // If b is 0, a is the gcd
        if (b == 0) {
            return a;
        }
        // Otherwise, recursively call the method with b and the remainder of a divided by b
        return greatestCommonDivisor(b, a % b);
    }
}