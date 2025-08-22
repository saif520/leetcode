class Solution {
    // Method to distribute candies into a number of gift boxes.
    public int distributeCandies(int candies, int limit) {
        // If the number of candies exceeds 3 times the limit of a gift box, distribution is not possible.
        if (candies > 3 * limit) {
            return 0;
        }
        // Calculate the combinations for the distribution with no limits
        long combinations = combinationPairs(candies + 2);
        // If the number of candies is greater than the limit, adjust the combinations count.
        if (candies > limit) {
            combinations -= 3 * combinationPairs(candies - limit + 1);
        }
        // If the number of candies exceeds twice the limit for a single gift box, adjust again.
        if (candies - 2 >= 2 * limit) {
            combinations += 3 * combinationPairs(candies - 2 * limit);
        }
        // Since the result needs to be an integer, cast the long to an int before returning.
        return (int) combinations;
    }

    // Helper method to calculate the number of pair combinations.
    private long combinationPairs(int n) {
        // Combinatorial formula for the number of combinations of pairs which is n choose 2.
        return 1L * n * (n - 1) / 2;
    }
}