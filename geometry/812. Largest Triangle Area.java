class Solution {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0; // Initialize maxArea as the largest triangle area found so far.

        // Iterate through all the points to get the first point (p1) of the triangle.
        for (int[] point1 : points) {
            int x1 = point1[0], y1 = point1[1];

            // Iterate through all the points to get the second point (p2) of the triangle.
            for (int[] point2 : points) {
                int x2 = point2[0], y2 = point2[1];

                // Iterate through all the points to get the third point (p3) of the triangle.
                for (int[] point3 : points) {
                    int x3 = point3[0], y3 = point3[1];

                    // Calculate the vectors from point1 to point2 and from point1 to point3
                    int vector1X = x2 - x1, vector1Y = y2 - y1;
                    int vector2X = x3 - x1, vector2Y = y3 - y1;

                    // Calculate the area of the triangle using the determinant |u1 v1|
                    //                                                   |u2 v2|
                    // which is |x2 - x1  y2 - y1|
                    //          |x3 - x1  y3 - y1| divided by 2. Note: this represents
                    // the absolute value of the cross product of vectors (point1 to point2)
                    // and (point1 to point3) divided by 2.
                    double area = Math.abs(vector1X * vector2Y - vector2X * vector1Y) / 2.0;

                    // Update maxArea if the calculated area is larger than the current maxArea.
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        // Return the largest area found.
        return maxArea;
    }
}