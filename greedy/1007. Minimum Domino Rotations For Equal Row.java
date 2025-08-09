class Solution {
    private int arrayLength;
    private int[] tops;
    private int[] bottoms;

    /**
     * Finds the minimum number of rotations to have all the values in either top or bottom equal.
     *
     * @param tops    - array representing the top values of each domino.
     * @param bottoms - array representing the bottom values of each domino.
     * @return minimum number of rotations, or -1 if it is not possible.
     */
    public int minDominoRotations(int[] tops, int[] bottoms) {
        // Set the global variables for easy access in the helper function.
        arrayLength = tops.length;
        this.tops = tops;
        this.bottoms = bottoms;

        // Check for the possibility of all dominos having the first top value or the first bottom value.
        int rotations = Math.min(findRotationsForValue(tops[0]), findRotationsForValue(bottoms[0]));

        // If the number of rotations is greater than the array length, it means it's impossible to achieve the goal.
        return rotations > arrayLength ? -1 : rotations;
    }

    /**
     * Helper function to calculate the rotations needed to make all the values of tops or bottoms equal to x.
     *
     * @param value - the value to match across all tops or bottoms.
     * @return number of rotations needed or a value greater than n if not possible.
     */
    private int findRotationsForValue(int value) {
        int countTops = 0, countBottoms = 0;

        // Traverse through all dominos.
        for (int i = 0; i < arrayLength; ++i) {
            // If the current domino does not have the desired value on either side, the configuration is not possible.
            if (tops[i] != value && bottoms[i] != value) {
                return arrayLength + 1;
            }

            // Increment count of occurrence of value in tops and bottoms.
            if (tops[i] == value) {
                countTops++;
            }
            if (bottoms[i] == value) {
                countBottoms++;
            }
        }

        // The minimum rotations is the length of the array minus
        // the maximum count of the value in either tops or bottoms.
        return arrayLength - Math.max(countTops, countBottoms);
    }
}