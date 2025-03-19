class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> intersections = new ArrayList<>();
        int firstLen = firstList.length, secondLen = secondList.length;

        // Use two-pointers technique to iterate through both lists
        int i = 0, j = 0; // i for firstList, j for secondList
        while (i < firstLen && j < secondLen) {
            // Find the start and end of the intersection, if it exists
            int startMax = Math.max(firstList[i][0], secondList[j][0]);
            int endMin = Math.min(firstList[i][1], secondList[j][1]);

            // Check if the intervals intersect
            if (startMax <= endMin) {
                // Store the intersection
                intersections.add(new int[] {startMax, endMin});
            }

            // Move to the next interval in the list that finishes earlier
            if (firstList[i][1] < secondList[j][1]) {
                i++; // Increment the pointer for the firstList
            } else {
                j++; // Increment the pointer for the secondList
            }
        }

        // Convert the list of intersections to an array before returning
        return intersections.toArray(new int[intersections.size()][]);
    }
}
