class Solution {
    /**
     * Determines if it's possible to measure exactly the target capacity using the two jugs.
     *
     * @param jug1Capacity the capacity of jug 1
     * @param jug2Capacity the capacity of jug 2
     * @param targetCapacity the target capacity to measure
     * @return true if it's possible to measure exact target capacity, false otherwise
     */
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        // If the sum of both jug capacities is less than the target, it's not possible to measure.
        if (jug1Capacity + jug2Capacity < targetCapacity) {
            return false;
        }
        // If one jug is of 0 capacity, we can only measure the target if 
        // it's 0 or equal to the capacity of the non-zero jug.
        if (jug1Capacity == 0 || jug2Capacity == 0) {
            return targetCapacity == 0 || jug1Capacity + jug2Capacity == targetCapacity;
        }
        // The target capacity must be a multiple of the greatest common divisor of the jug capacities.
        return targetCapacity % greatestCommonDivisor(jug1Capacity, jug2Capacity) == 0;
    }

    /**
     * Computes the greatest common divisor (GCD) of two numbers using Euclidean algorithm.
     *
     * @param a the first number
     * @param b the second number
     * @return the greatest common divisor (GCD) of a and b
     */
    private int greatestCommonDivisor(int a, int b) {
        // If the second number is 0, return the first number, otherwise, recursively
        // find the GCD of the second number and the remainder of the first number divided by the second number.
        return b == 0 ? a : greatestCommonDivisor(b, a % b);
    }
}
