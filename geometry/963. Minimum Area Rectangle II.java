class Solution {
    public double minAreaFreeRect(int[][] points) {
        int n = points.length;
        // Using a HashSet to store unique representations of points
        Set<Integer> pointSet = new HashSet<>();
        for (int[] point : points) {
            pointSet.add(encode(point[0], point[1]));
        }
        // Initialize the minimum area to the maximum possible value
        double minArea = Double.MAX_VALUE;
        // Iterate through all combinations of three points to find the fourth point
        for (int i = 0; i < n; ++i) {
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = 0; j < n; ++j) {
                if (j != i) {
                    int x2 = points[j][0], y2 = points[j][1];
                    for (int k = j + 1; k < n; ++k) {
                        if (k != i) {
                            int x3 = points[k][0], y3 = points[k][1];
                            // Calculate potential fourth point's coordinates
                            int x4 = x2 - x1 + x3, y4 = y2 - y1 + y3;
                            // Check if the fourth point exists in the set
                            if (pointSet.contains(encode(x4, y4))) {
                                // Check if the three points form a right angle
                                if ((x2 - x1) * (x3 - x1) + (y2 - y1) * (y3 - y1) == 0) {
                                    // Calculate the square of the rectangle's width and height
                                    int widthSquared = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
                                    int heightSquared = (x3 - x1) * (x3 - x1) + (y3 - y1) * (y3 - y1);
                                    // Update the minimum area, if smaller than the current minimum area
                                    minArea = Math.min(minArea, Math.sqrt((long) widthSquared * heightSquared));
                                }
                            }
                        }
                    }
                }
            }
        }
        // Return 0 if no rectangle is found, otherwise return the minimum area found
        return minArea == Double.MAX_VALUE ? 0 : minArea;
    }

    // Helper function to encode a 2D point into a unique integer
    private int encode(int x, int y) {
        // We use 40001 as a base for encoding since the problem statement might give a max coordinate value of 40000
        return x * 40001 + y;
    }
}