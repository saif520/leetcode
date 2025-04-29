class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        // Determine the number of queries to process
        int queryCount = queries.length;

        // Prepare an array to store the results for each query
        int[] answer = new int[queryCount];

        // Loop through each query
        for (int k = 0; k < queryCount; ++k) {
            // Retrieve the center and radius of the current query circle
            int centerX = queries[k][0];
            int centerY = queries[k][1];
            int radius = queries[k][2];

            // Loop through each point to check if it is inside the query circle
            for (int[] point : points) {
                // Extract the coordinates of the point
                int pointX = point[0];
                int pointY = point[1];

                // Calculate the distance from the point to the center of the circle
                int distanceX = pointX - centerX;
                int distanceY = pointY - centerY;

                // Check if the point is within the circle by comparing the squares of the distances
                if (distanceX * distanceX + distanceY * distanceY <= radius * radius) {
                    // Increment the counter for this query if the point is inside the circle
                    ++answer[k];
                }
            }
        }

        // Return the array containing the count of points within each circle
        return answer;
    }
}